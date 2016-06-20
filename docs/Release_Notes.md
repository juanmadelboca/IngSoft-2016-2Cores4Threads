# Release Notes #

----------

> **Fecha:** 19/06/2016  
> **Autor:** 2Cores4Threads  
> **Version:** v2.0.0  
> 
> **Funcionalidades Incluidas:**  
> 
> - Nueva vista(SelectionTestDrive) con selección en tiempo de ejecución del modelo a utilizar.  
> - Actualización de la vista del sistema(Preguntas multiple-choice):  
> 	- Ya no permite ingresar preguntas nulas al agregar nuevas preguntas.  
> 	- Implementada la tabla de máximas puntuaciones al finalizar la partida.  
> - Actualización del modelo de preguntas:  
> 	- Cuando el tiempo llega a 0, se termina la partida y muestra la tabla de máximas puntuaciones(con sus respectivos nombres).  
> 	- El sistema ya no envía preguntas repetidas, si el usuario finaliza toda la grilla de preguntas, se acaba el juego.  
> 	- Al finalizar el juego el usuario puede volver a jugar desde el menu “Nuevo Jugador” sin necesidad de reiniciar la vista, con el tiempo seteado anteriormente.  
> - Actualización de la base de datos:
> 	- Se generarán 2 archivos .obj, en uno se guardarán los máximos puntajes y en el otro la grilla de preguntas.  
> 	- Si no existen estos archivos, el sistema los creará automáticamente.  
> 
> **Bugs conocidos:**  
> 
> - No se restringe el ingreso de tiempo negativo o cero, lo que induce un colapso del juego.  
> - Los primeros segundos del SelectionTestDrive muestra ventanas de los modelos creados.  
> 
> **Comentarios:**  
> 
> - No se cargaron nuevas preguntas en la base de datos.


----------


> **Fecha:** 13/06/2016  
> **Autor:** 2Cores4Threads  
> **Version:** v1.0.0  
> **Funcionalidades incluidas:**  
> 
> - Nueva vista del sistema(Preguntas multiple-choice):
> 	- Posibilidad de agregar nuevas preguntas  
> 	- Tiempo implementado en real time  
> 	- Score implementado en real time
> - Nueva vista(HeartTestDrive) del HeartModel con contador de instancias cuando selecciono “>>”.  
> 
> **Bugs conocidos:**  
> 
> - No sucede nada cuando el tiempo llega a 0.  
> - Posibilidad de enviar null como pregunta/respuesta cuando añade una nueva.  
> - El sistema envía mas de una vez la misma pregunta.  
> 
> **Comentarios:**  
> 
> - Ingresar el nombre no tiene ninguna incidencia

----------

