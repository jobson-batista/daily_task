/**
 *  Validação de formulários
 * @author Dev Jobson
 */

 function validate() {
	 let description = formTask.description.value;
	 
	 if (description === "") {
		 alert("O campo 'Descrição' não pode ser vazio!");
		 formTask.description.focus();
		 return false;
	 } else {
		document.forms["formTask"].submit();
	 }
	 
 }