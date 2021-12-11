var filteChoosed =document.querySelectorAll(".filter-item ul li")
var filtePrice =document.querySelector("a[data-type='price'] span")
var filteCapacity= document.querySelector("a[data-type='capacity'] span")

Length = filteChoosed.length;

for (var i=0;i<Length;i++){
    filteChoosed[i].addEventListener("click",function(e ){
        if(e.target.classList.contains("price-item")){
            // show box price
            var filteE =document.querySelector("a[data-type='price']")
            filteE.style.display="inline"
            // convert inertext for span element
            var a = this.querySelector("i");
            a.style.display="inline"
            filtePrice.innerText= e.target.innerText
        }
        if(e.target.classList.contains("capacity-item")){
            var filteE =document.querySelector("a[data-type='capacity']")
            filteE.style.display="inline"
            var a = this.querySelector("i");
            a.style.display="inline"
            filteCapacity.innerText= e.target.innerText
        }
    })
}
