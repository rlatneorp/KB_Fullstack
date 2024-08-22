# tbl_member를 그냥 삭제하면 외래키 제약조건 때문에 삭제가 안되기 때문에 해당 코드 필요
# fk_authorities_users 제약조건 삭제하는 코드
ALTER TABLE tbl_member_auth DROP FOREIGN KEY fk_authorities_users;

-- 사용자 정보 테이블
drop table if exists tbl_member;

create table tbl_member
(
    username varchar(50) primary key,   -- 사용자 id
    password varchar(128) not null,     -- 암호화된 비밀번호
    email varchar(50) not null,
    reg_date datetime default now(),
    update_date datetime default now()
);

-- 사용자 권한 테이블
drop table if exists tbl_member_auth;

create table tbl_member_auth
(
    username varchar(50) not null,   -- 사용자 id
    auth varchar(50) not null,       -- 권한 문자열 ROLE_ADMIN, ROLE_MANAGER, ROLE_MEMBER 등
    primary key(username, auth),     -- 복합키
    #     tbl_member_auth의 username이 tbl_member의 username을 참조한다
#     해당 제약조건의 이름을  fk_authorities_users로 지정한다
    constraint fk_authorities_users foreign key (username) references tbl_member(username)
);

-- 테스트 사용자 추가
insert into tbl_member(username, password, email)
values
    ('admin', '$2a$10$Et4lZJlaF7Y2MBvQuQazZeJaeI39eyo9eOerNta50Gk//LVyN2vUW', 'admin@galapgos.org'),
    ('user0', '$2a$10$Et4lZJlaF7Y2MBvQuQazZeJaeI39eyo9eOerNta50Gk//LVyN2vUW', 'user0@galapgos.org'),
    ('user1', '$2a$10$Et4lZJlaF7Y2MBvQuQazZeJaeI39eyo9eOerNta50Gk//LVyN2vUW', 'user1@galapgos.org'),
    ('user2', '$2a$10$Et4lZJlaF7Y2MBvQuQazZeJaeI39eyo9eOerNta50Gk//LVyN2vUW', 'user2@galapgos.org'),
    ('user3', '$2a$10$Et4lZJlaF7Y2MBvQuQazZeJaeI39eyo9eOerNta50Gk//LVyN2vUW', 'user3@galapgos.org'),
    ('user4', '$2a$10$Et4lZJlaF7Y2MBvQuQazZeJaeI39eyo9eOerNta50Gk//LVyN2vUW', 'user4@galapgos.org');

select * from tbl_member;

insert into tbl_member_auth(username, auth)
values
    ('admin','ROLE_ADMIN'),
    ('admin','ROLE_MANAGER'),
    ('admin','ROLE_MEMBER'),
    ('user0','ROLE_MANAGER'),
    ('user0','ROLE_MEMBER'),
    ('user1','ROLE_MEMBER'),
    ('user2','ROLE_MEMBER'),
    ('user3','ROLE_MEMBER'),
    ('user4','ROLE_MEMBER');

# auth를 ABC순으로 오름차순 정렬해서 조회
select * from tbl_member_auth order by auth;


# member 테이블을 기준으로 아우터 조인시켰으므로 권한 정보가 없는 사용자도 조회된다
# username이 'admin'인 사용자의 정보를 권한과 함께 조회
SELECT m.username, password, email, reg_date, update_date, auth
FROM tbl_member m
         LEFT OUTER JOIN tbl_member_auth a
                         ON m.username = a.username
WHERE m.username = 'admin';