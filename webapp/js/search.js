function searchCategory(str)
{
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function()
	{
		if(this.readyState==4 && this.status==200)
		{
			document.getElementById("d").innerHTML=this.responseText;
		}
	}
   xhttp.open("GET","search?catName="+str,true);
   xhttp.send();	
}