import{_ as g,a as C,l as x,u as D,b as N,o as l,d as r,e as a,t as c,g as n,p as h,F as m,m as B,f as S,q as I,s as Y}from"./index-CW_Ktslo.js";import{b as f}from"./boardApi-CXxE0Mcj.js";import{h as F}from"./moment-C5S46NFB.js";import"./index-CUhkxjML.js";const R=async o=>{try{const t=document.createElement("a");t.href=o,document.body.appendChild(t),t.click(),document.body.removeChild(t)}catch(t){console.error(t)}},s=o=>(I("data-v-28696695"),o=o(),Y(),o),V={className:"my-3 d-flex justify-content-between"},q=s(()=>a("i",{className:"fa-solid fa-user"},null,-1)),A=s(()=>a("i",{className:"fa-regular fa-clock"},null,-1)),E=s(()=>a("hr",null,null,-1)),H={class:"text-end"},L=["onClick"],M=s(()=>a("i",{class:"fa-solid fa-paperclip"},null,-1)),P={class:"content"},j={class:"my-5"},T=s(()=>a("i",{class:"fa-solid fa-list"},null,-1)),U=s(()=>a("i",{class:"fa-regular fa-pen-to-square"},null,-1)),$=s(()=>a("i",{class:"fa-solid fa-trash-can"},null,-1)),z={__name:"BoardDetailPage",setup(o){const t=C(),b=x(),i=D(),d=b.params.no,e=N({}),v=async p=>{const _="/api/board/download/"+p;await R(_)},y=()=>{i.push({name:"board/list"})},k=()=>{i.push({name:"board/update",params:{no:d}})},w=async()=>{confirm("삭제할까요?")&&(await f.delete(d),i.push({name:"board/list"}))};return(async()=>{e.value=await f.get(d)})(),(p,_)=>(l(),r(m,null,[a("h1",null,c(e.value.title),1),a("div",V,[a("div",null,[q,n(" "+c(e.value.writer),1)]),a("div",null,[A,n(" "+c(h(F)(e.value.updateDate).format("YYYY-MM-DD HH:mm")),1)])]),E,a("div",H,[(l(!0),r(m,null,B(e.value.attaches,u=>(l(),r("div",{key:u.no,class:"attach"},[a("span",{onClick:J=>v(u.no)},[M,n(" "+c(u.filename),1)],8,L)]))),128))]),a("div",P,c(e.value.content),1),a("div",j,[a("button",{class:"btn btn-primary me-2",onClick:y},[T,n(" 목록 ")]),h(t).username==e.value.writer?(l(),r(m,{key:0},[a("button",{class:"btn btn-primary me-2",onClick:k},[U,n(" 수정 ")]),a("button",{class:"btn btn-danger",onClick:w},[$,n(" 삭제 ")])],64)):S("",!0)])],64))}},X=g(z,[["__scopeId","data-v-28696695"]]);export{X as default};