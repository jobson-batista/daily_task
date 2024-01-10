/** Confirmação de Exclusão (Exclusão Lógica) e 
 *  @author Dev Jobson
 */

 function confirmDelete(id) {
	 let response = confirm('Deseja deletar essa Tarefa?');
	 if(response === true) {
		 window.location.href = "delete?id=" + id;
	 }
 }