import{b as w}from"./boardApi-BemUchxc.js";import{h as q}from"./moment-C5S46NFB.js";import{u as x,a as k,c as C,d as V,r as B,m as D,j as f,o as u,e as i,f as t,t as l,F as I,p as N,k as d,l as o,q as c,h as p}from"./index-CmunP76s.js";import"./index-DAK0-K4R.js";const Y=t("h1",{class:"mb-3"},[t("i",{class:"fa-solid fa-paste"}),p(" 게시글 목록")],-1),L={class:"mt-5 text-end"},R={class:"table table-striped"},A=t("thead",null,[t("tr",null,[t("th",{style:{width:"60px"}},"No"),t("th",null,"제목"),t("th",{style:{width:"100px"}},"작성자"),t("th",{style:{width:"120px"}},"작성일")])],-1),F={class:"my-5 d-flex"},M={class:"flex-grow-1 text-center"},P=t("i",{class:"fa-solid fa-backward-fast"},null,-1),T=t("i",{class:"fa-solid fa-caret-left"},null,-1),j=t("i",{class:"fa-solid fa-caret-right"},null,-1),E=t("i",{class:"fa-solid fa-forward-fast"},null,-1),H=t("i",{class:"fa-solid fa-pen-to-square"},null,-1),J={__name:"BoardListPage",setup(S){const e=x(),g=k(),n=C({}),y=V(()=>n.value.list),s=B({page:parseInt(e.query.page)||1,amount:parseInt(e.query.amount)||10}),b=async r=>{g.push({query:{page:r,amount:s.amount}})};D(e,async r=>{console.log("WATCH",e.query.page),s.page=parseInt(e.query.page),s.amount=parseInt(e.query.amount),await m()});const m=async()=>{try{n.value=await w.getList(),console.log(n.value)}catch{}};return m(),(r,_)=>{const h=f("router-link"),v=f("vue-awesome-paginate");return u(),i("div",null,[Y,t("div",L,"(총 "+l(n.value.totalCount)+"건)",1),t("table",R,[A,t("tbody",null,[(u(!0),i(I,null,N(y.value,a=>(u(),i("tr",{key:a.no},[t("td",null,l(a.no),1),t("td",null,[d(h,{to:{name:"board/detail",params:{no:a.no},query:c(e).query}},{default:o(()=>[p(l(a.title),1)]),_:2},1032,["to"])]),t("td",null,l(a.writer),1),t("td",null,l(c(q)(a.regDate).format("YYYY-MM-DD")),1)]))),128))])]),t("div",F,[t("div",M,[d(v,{"total-items":n.value.totalCount,"items-per-page":s.amount,"max-pages-shown":5,"show-ending-buttons":!0,modelValue:s.page,"onUpdate:modelValue":_[0]||(_[0]=a=>s.page=a),onClick:b},{"first-page-button":o(()=>[P]),"prev-button":o(()=>[T]),"next-button":o(()=>[j]),"last-page-button":o(()=>[E]),_:1},8,["total-items","items-per-page","modelValue"])]),t("div",null,[d(h,{to:{name:"board/create",query:c(e).query},class:"btn btn-primary"},{default:o(()=>[H,p(" 글 작성")]),_:1},8,["to"])])])])}}};export{J as default};
