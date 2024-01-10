/** Confirmação de Exclusão (Exclusão Lógica) e de Finalizar tarefa
 *  @author Dev Jobson
 */

 function confirmDelete(id) {
	 let response = confirm('Deseja deletar essa Tarefa?');
	 if(response === true) {
		 window.location.href = "delete?id=" + id;
	 }
 }
 
  function confirmFinish(id) {
	 /*let response = confirm('Deseja finalizar essa Tarefa?');
	 if(response === true) {
		window.location.href = "check?id=" + id; 
	 }*/
	 window.location.href = "check?id=" + id;
 }