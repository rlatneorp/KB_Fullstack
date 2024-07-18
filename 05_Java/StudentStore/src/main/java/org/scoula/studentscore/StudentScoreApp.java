package org.scoula.studentscore;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;
import org.scoula.studentscore.service.StudentScoreService;

//커스터마이징하는 부분만 App 클래스에서 추출하여 자식 클래스 생성
public class StudentScoreApp extends App {
//    service 클래스 내에 메뉴 관련 메소드들을 모두 넣고 서비스 객체 생성
    StudentScoreService service = new StudentScoreService();

//    메소드 참조로 서비스 객체 내에 있는 메소드 접근
    @Override
    public void createMenu(Menu menu) {
        menu.add(new MenuItem("학생수", service::initScores));
        menu.add(new MenuItem("점수입력", service::getScores));
        menu.add(new MenuItem("점수리스트", service::printScores));
        menu.add(new MenuItem("분석", service::analize));
    }
    
    public static void main(String[] args) {
        App app = new StudentScoreApp();
        app.run();
    }
}