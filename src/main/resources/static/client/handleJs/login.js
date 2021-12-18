
if(localStorage.username != null){
	$("#usernameLogin").val(localStorage.getItem("username"));
}

$("#btn-signup").click(function(event){
	event.preventDefault();
	var form = $('#registerForm')[0];
	var data = new FormData(form);
	if(validateFormRegister()){
		$.ajax({
			url : "/api/v1/users/user",
			type:"POST",
			data : data,
			processData: false,
		    contentType: false,
		    cache: false,
		    timeout: 1000000,
			success : function(jsonResult){
				if(jsonResult.status == 200){			
					alert("Success");
					localStorage.username = jsonResult.data.username;
					window.location.href = "/login"
				}else {
					alert(jsonResult.message);
				}
			},
			error : function(jqXhr, textStatus, errorMessage) { // error
				// callback

			} 
		});
	}
});


function validateFormRegister() {
	let fullname = document.getElementById("fullname").value;
	let email = document.forms["registerForm"]["email"].value;
	let username = document.forms["registerForm"]["username"].value;
	let name = document.forms["registerForm"]["name"].value;
	let password = document.forms["registerForm"]["password"].value;
	let confirm_password = document.forms["registerForm"]["password_confirmation"].value;

	if (fullname == "") {
		alert("Tên không được trống");
		return false;
	}
	if (email == "") {
		alert("Email không được trống");
		return false;
	}
	if (username == "") {
		alert("username không được trống");
		return false;
	}
	if (name == "") {
		alert("Tên không được trống");
		return false;
	}
	if (password == "") {
		alert("password không được trống");
		return false;
	}
	if (confirm_password == "") {
		alert("Tên không được trống");
		return false;
	}
	if(!(password === confirm_password)){
		alert("Password không giống nhau");
		return false;
	}
	return true;
}

//function validator(options) {
//
//    var arrRules = {};
//    function getParent(element,selector){
//      while(element.parentElement){
//        if(element.parentElement.matches(selector)){
//          return element.parentElement;
//        }
//        else{
//          element=element.parentElement;
//        }
//      }
//    }
//     function validate (inputElement,arrRules,rule){
//       rules=arrRules[rule.selector];
//      var formError = getParent(inputElement,options.formGroup).querySelector(`${options.formError}`)
//      var formGroup = getParent(inputElement,options.formGroup);
//      for(var i=0;i<rules.length;i++){
//        errormesage = rules[i](inputElement.value);
//        switch(inputElement.type){
//          case 'radio':{
//          
//              errormesage = rules[i](formElement.querySelector(rule.selector + ':checked'));
//              break;
//          }
//          default :{
//              errormesage = rules[i](inputElement.value);
//          }
//        }
//        if(errormesage){
//          formError.innerText = errormesage;
//          formGroup.classList.add('invalid');
//          break;
//        }
//        else {
//          formError.innerText = '';
//          formGroup.classList.remove('invalid');
//        }
//      }
//      return !errormesage;
//    }
//    var formElement=document.querySelector(`${options.form}`)
//    //xử lý kiểm tra các rule cho từng ô input
//    options.Rules.forEach( rule => {
//      var inputElements = formElement.querySelectorAll(rule.selector);
//  
//      if(Array.isArray(arrRules[rule.selector])){
//        arrRules[rule.selector].push(rule.test);
//      }
//      else {
//       arrRules[rule.selector] = [rule.test];
//      }
//      Array.from(inputElements).forEach(inputElement => {
//        if(inputElement){
//          inputElement.onblur = function(e){
//          validate(inputElement,arrRules,rule);
//         }
//         inputElement.oninput = function() {
//          var formError = getParent(inputElement,options.formGroup)
//          .querySelector(`${options.formError}`)
//          var formGroup = getParent(inputElement,options.formGroup);    
//          formError.innerText = '';
//          formGroup.classList.remove('invalid');
//         }
//        }
//      })
//      // if(inputElement){
//      //   inputElement.onblur = function(e){
//      //   validate(inputElement,arrRules,rule);
//      //  }
//      //  inputElement.oninput = function() {
//      //   formError.innerText = '';
//      //   formGroup.classList.remove('invalid');
//      //  }
//      // }
//     
//    })
//    //xử lý submit form
//    formElement.onsubmit=function(e){
//      isFormValid = true;
//      e.preventDefault()
//      options.Rules.forEach(rule=>{
//      var inputElement = formElement.querySelector(rule.selector);
//          var valid= validate(inputElement,arrRules,rule);
//          if(!valid){
//            isFormValid=false;
//         }
//      })
//    
//      if(isFormValid){
//        var inputElement = formElement.querySelectorAll("[name]");
//        var data =Array.from(inputElement).reduce((values,input)=>{
//          switch(input.type){
//            case 'radio':{
//              if(input.matches(":checked")){
//                  values[input.name] = input.value;
//                }
//                break;
//            }
//            case 'checkbox':{
//              if(input.matches(":checked")){
//                if(!Array.isArray(values[input.name])){
//                  values[input.name]=[input.value];
//                }
//                 else{
//                  values[input.name].push(input.value);
//                 } 
//                }
//                break;
//            }
//            case 'file':{
//                  values[input.name] = input.files;
//                break;
//            }
//            default:{
//               values[input.name]= input.value;
//            }
//          }
//          return values
//        },{})
//        if(typeof(options.formSubmit) == "function"){
//          options.formSubmit(data);
//        }
//        else{
//          formElement.submit();
//        }
//      }
//    }
//  }
//  
//  validator.isRequired = function(selector){
//  return {
//    selector:selector,
//    test:function(value){
//        return value?undefined:"vui lòng nhập trường này";
//    }
//  }
//  };
//  validator.isEmail = function(selector) {
//    return {
//      selector:selector,
//      test:function(value){
//        var regex=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//       return regex.test(value)?undefined:"trường này phải là email";
//      }
//    }
//  }
//  validator.minlength = function(selector,min){
//    return {
//      selector:selector,
//      test:function(value){
//       return value.length >= min?undefined:`vui lòng nhập tối thiểu ${min} ký tự`;
//      }
//    }
//   };
//  
//  validator.isconfirmed =function(selector,callback){
//    return {
//      selector:selector,
//      test:function(value){
//        return value === callback()?undefined:`mật khẩu nhập lại chưa chính xác`;
//       } 
//    }
//  }
//
//
//  
//  validator({
//    form: "#form-1",
//    formGroup: ".form-group",
//    formError: ".form-message",
//    Rules: [
//      validator.isRequired("#fullname"),
//      validator.isRequired("#phonenumber"),
//      validator.isRequired("#email"),
//      validator.isEmail("#email"),
//      validator.isRequired("#password"),
//      validator.minlength("#password", 6),
//      validator.isRequired("#password_confirmation"),
//      validator.isconfirmed("#password_confirmation", function () {
//        return document.querySelector("#password").value;
//      }),
//    ],
//    formSubmit(data) {
//      console.log(data);
//    },
//  });