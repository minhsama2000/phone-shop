
function validator(options) {

  var arrRules = {};
  function getParent(element,selector){
    while(element.parentElement){
      if(element.parentElement.matches(selector)){
        return element.parentElement;
      }
      else{
        element=element.parentElement;
      }
    }
  }
   function validate (inputElement,arrRules,rule){
     rules=arrRules[rule.selector];
    var formError = getParent(inputElement,options.formGroup).querySelector(`${options.formError}`)
    var formGroup = getParent(inputElement,options.formGroup);
    for(var i=0;i<rules.length;i++){
      errormesage = rules[i](inputElement.value);
      switch(inputElement.type){
        case 'radio':{
        
            errormesage = rules[i](formElement.querySelector(rule.selector + ':checked'));
            break;
        }
        default :{
            errormesage = rules[i](inputElement.value);
        }
      }
      if(errormesage){
        formError.innerText = errormesage;
        formGroup.classList.add('invalid');
        break;
      }
      else {
        formError.innerText = '';
        formGroup.classList.remove('invalid');
      }
    }
    return !errormesage;
  }
  var formElement=document.querySelector(`${options.form}`)
  //xử lý kiểm tra các rule cho từng ô input
  options.Rules.forEach( rule => {
    var inputElements = formElement.querySelectorAll(rule.selector);

    if(Array.isArray(arrRules[rule.selector])){
      arrRules[rule.selector].push(rule.test);
    }
    else {
     arrRules[rule.selector] = [rule.test];
    }
    Array.from(inputElements).forEach(inputElement => {
      if(inputElement){
        inputElement.onblur = function(e){
        validate(inputElement,arrRules,rule);
       }
       inputElement.oninput = function() {
        var formError = getParent(inputElement,options.formGroup)
        .querySelector(`${options.formError}`)
        var formGroup = getParent(inputElement,options.formGroup);    
        formError.innerText = '';
        formGroup.classList.remove('invalid');
       }
      }
    })
    // if(inputElement){
    //   inputElement.onblur = function(e){
    //   validate(inputElement,arrRules,rule);
    //  }
    //  inputElement.oninput = function() {
    //   formError.innerText = '';
    //   formGroup.classList.remove('invalid');
    //  }
    // }
   
  })
  //xử lý submit form
  formElement.onsubmit=function(e){
    isFormValid = true;
    e.preventDefault()
    options.Rules.forEach(rule=>{
    var inputElement = formElement.querySelector(rule.selector);
        var valid= validate(inputElement,arrRules,rule);
        if(!valid){
          isFormValid=false;
       }
    })
  
    if(isFormValid){
      var inputElement = formElement.querySelectorAll("[name]");
      var data =Array.from(inputElement).reduce((values,input)=>{
        switch(input.type){
          case 'radio':{
            if(input.matches(":checked")){
                values[input.name] = input.value;
              }
              break;
          }
          case 'checkbox':{
            if(input.matches(":checked")){
              if(!Array.isArray(values[input.name])){
                values[input.name]=[input.value];
              }
               else{
                values[input.name].push(input.value);
               } 
              }
              break;
          }
          case 'file':{
                values[input.name] = input.files;
              break;
          }
          default:{
             values[input.name]= input.value;
          }
        }
        return values
      },{})
      if(typeof(options.formSubmit) == "function"){
        options.formSubmit(data);
      }
      else{
        formElement.submit();
      }
    }
  }
}

validator.isRequired = function(selector){
return {
  selector:selector,
  test:function(value){
      return value?undefined:"vui lòng nhập trường này";
  }
}

};
validator.isEmail = function(selector) {
  return {
    selector:selector,
    test:function(value){
      var regex=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
     return regex.test(value)?undefined:"trường này phải là email";
    }
  }
}
var resApi="http://localhost:3000/users"
function createCourse(data,callback) {
    console.log(data)
        var options = {
            method: "POST",
            headers: {
            "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        }
        fetch(resApi, options)
}

function inforCheckout  (ten,sodt,diachi,tensanpham,soluong,tongtien){
  this.ten=ten,
  this.sodt=sodt,
  this.diachi=diachi,
  this.tensanpham=tensanpham,
  this.soluong= soluong,
  this.tongtien=tongtien
}

var checkBtn = document.getElementById("checkout");
checkBtn.onclick= function checkCart (){
  var ten=document.querySelector(".input_full_name").value;
  var sodt=document.querySelector(".input_phone_number").value;
  var diachi=document.querySelector(".input_address_detail").value;
  var email=document.querySelector(".input_email_custom").value;
  var tensanpham=document.querySelector(".product_name").innerText
  console.log(tensanpham)
  var tongtien= document.querySelector(".total_check").textContent
  console.log(tongtien)
  var data = {
    ten:ten,
    sodt:sodt,
    diachi:diachi,
    email:email,
    tensanpham:tensanpham,
    tongtien:tongtien
  }

  fetch("http://localhost:3000/listcheckout",{
    method: "POST",
    headers: {
    "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
})
 alert("đơn hàng đã được gửi")
}


