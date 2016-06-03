# **Plan de Gestión de la Configuración** #

----------

## INDICE ##

- [1. Introducción](#1-introducción)
	- [1.1. Propósito](#11-propósito)
	- [1.2. Alcance](#12-alcance) 
	- [1.3. Definiciones, Acrónimos, y Abreviaturas](#13-definiciones-acrónimos-y-abreviaturas)
	- [1.4. Herramientas utilizadas](#14-herramientas-utilizadas)
- [2. Organización de la Gestión de la Configuración](#2-organización-de-la-gestión-de-la-configuracióncm)
	- [2.1. Organización](#21-organización)
	- [2.2. Responsabilidades](#22-responsabilidades)
- [3. Change Management](#3-change-management)
	- [3.1. Alcance](#31-alcance)
	- [3.2. Junta de Control de Cambio(CCB)](#32-junta-de-control-de-cambioccb)
		- [3.2.1. Integrantes](#321-integrantes)
		- [3.2.2. Frecuencia](#322-frecuencia)
		- [3.2.3. Herramientas Utilizadas](#323-herramientas-utilizadas)
- [4. Esquema de Directorios](#4-esquema-de-directorios)
- [5. Equipos del Proyecto](#5-equipos-del-proyecto)
- [6. Gestión de Configuración del Código Fuente](#6-gestión-de-configuración-de-código-fuente)
	- [6.1. Definiciones y Estrategias](#61-definiciones-y-estrategias)
		- [6.1.1. Definición de las Ramas](#611-definición-de-las-ramas)
		- [6.1.2. Definición de las Etiquetas](#612-definición-de-las-etiquetas)
		- [6.1.3. Archivos Auxiliares de la CM](#613-archivos-auxiliares-de-cm)
		- [6.1.4. Estrategia de Merge](#614-estrategia-de-merge)
		- [6.1.5. Estrategia de Commit](#615-estrategia-de-commits)
- [7. Issues Management](#7-issues-management)
- [8. Build Management](#8-build-management)
- [9. Release Management](#9-release-management)   


----------


## 1. Introducción ##

### 1.1. Propósito ###

El propósito de este documento es definir el plan de gestión de las configuraciones para administrar la configuración de los requerimientos, software, documentos y herramientas utilizadas en este proyecto.

### 1.2. Alcance ###

El alcance de este documento es especificar los parámetros de configuración requeridos para el manejo del ambiente computacional y las herramientas de software a utilizar, especificar los responsables de cada una de las actividades halladas durante el desarrollo del presente.

### 1.3. Definiciones, Acrónimos, y Abreviaturas ###

| Acrónimo | Descripción                                        |
|----------|----------------------------------------------------|
| BO       | Business Operation                                 |
| CCB      | Change Control Board                               |
| CILOC    | Configuration Items Location                       |
| CM       | Configuration Management                           |
| PCM      | Project Configuration Management                   |
| PSO      | Professional Services Organization                 |
| SI&T     | System Integration and Test                        |
| SOP      | Standard Operating Procedure                       |
| SCM      | Software Configuration Management                  |
| Tag      | a.k.a labels. Identifiers for a Configuration Item |
| CI       | Configuration Item                                 |

### 1.4. Herramientas utilizadas ###

| Herramienta | Descripción | Link |
|-------------|--------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| GitHub | Repositorio remoto donde se alojará el código y se realizará la gestión de defectos. | https://github.com/juanmadelboca/IngSoft-2016-2Cores4Threads |
| Travis | Servidor de integración continua integrado al repositorio en GitHub | https://travis-ci.org/juanmadelboca/IngSoft-2016-2Cores4Threads |
| Gradle | Herramienta de compilación para interfaz Travis/GitHub | Integrado al GitHub |
| Excel | Herramienta que se utilizará para gestionar los cambios en las distintas versiones. | Local |

## 2. Organización de la Gestión de la Configuración(CM) ##

### 2.1. Organización ###

Las actividades realizadas dentro del proyecto de CM van a ser coordinadas por el Gerente Global de la Gestión de la Configuración(GPCM), rol que será asignado solo a una persona.
Adicionalmente, existirá también un Vice Gerente designado dentro del equipo.
El PCM Global será responsable de las actividades como el seguimiento de las rama principal y de release, determinar cuándo se crean ramas, que tipo de actividades de desarrollo se ejecuta en cual rama, etc.
También los equipos de desarrollo, como por ejemplo equipos de scrum, pueden tener su propio CM (TPCM) para llevar a cabo las actividades de CM pertenecientes al equipo y ayudar a la GPCM con el nivel más alto de proyecto.
Actividades de gestión de configuración, procesos, procedimientos y políticas deberán ser seguidas por todos los miembros del equipo. Es la responsabilidad de cada persona para seguir y aplicar el proceso de CM adecuada, de acuerdo con sus roles / funciones asignadas.

Los responsables del GPCM se muestran en la siguiente tabla:

| Rol | Nombre |
|--------------------|-------------------------------|
| Global PCM Primary | Di Lorenzo Franco |
| Global PCM Backup | Del Boca Juan - Rivero Franco |

### 2.2. Responsabilidades ###

Los roles y responsabilidades dentro del PCM se muestran a continuación:

| Rol | Responsabilidad |
|--------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| GPCM | Posee toda la responsabilidad por todos los ítems de configuración (CI). Responsabilidad por la creación de todas las ramas y la administración de sus reglas. Responsable de la aplicación de etiquetas en la rama principal y de release- Garantizar la integridad del producto y la trazabilidad de los CI para todo el proyecto. Coordinar las actividades de CM dentro del proyecto. Garantizar la correcta ejecución del esquema de CM.Asistir en las actividades de unión(merge) de la rama principal y de release. Responsabilidad en los build de la rama principal y de release. Participar en todas las auditorías. Analizar todos los hallazgos relacionados a la CM. |
| TPCM | Asistir en la creación de etiquetas y ramas. Asistir en las actividades de merge de nuevo código a la rama principal. Responsabilidad en los build de ramas específicas del equipo. Garantizar la integridad del producto y la trazabilidad de los CI bajo responsabilidad del equipo. Participar en las auditorías. Analizar todos los hallazgos relacionados a la CM. |
| Team(equipo) | Ayudar a resolver conflictos durante las actividades de merge. Asegurarse de que los criterios de calidad de los entregables a la rama principal se cumplan. Seguir todos los procesos asociados, políticas y prácticas definidas por sus roles asignados. |

## 3. Change Management ##

### 3.1. Alcance ###

Change Management es un proceso que ocurre después de identificar y aprobar la documentación, código fuente o hardware del producto. Los cambios incluyen cambios internos en el enfoque documentado original debido a la simulación o resultados de pruebas o peticiones externas de cambios en las características o funciones.

### 3.2. Junta de Control de Cambio(CCB) ###

La CCB es un comité que asegura que cada cambio realizado es considerado adecuado por todas las partes y está autorizado antes de su aplicación. La CCB es responsable de aprobar, supervisar y controlar las solicitudes de cambio para establecer líneas de base de los elementos de configuración.

#### 3.2.1. Integrantes ####

La siguiente tabla muestra los miembros del equipo que asisten a las reuniones de CCB. Los miembros opcionales se los invita si es necesario.

| Rol | Miembro Obligatorio |
|-------------------------------------|---------------------|
| Engineering Manager - CCB Chair | Si |
| Release Manager - Issue Coordinator | Si |
| Engineering Manager | No |
| Ubber Scrum Team | No |
| Engineering Director | No |
| GPCM | Si |

#### 3.2.2. Frecuencia ####

La CCB se debe juntar semanalmente o excepcionalmente la situación lo amerite.

#### 3.2.3. Herramientas Utilizadas ####

Para tener un seguimiento de los cambios introducidos se utilizará como herramienta el Microsoft Excel.

## 4. Esquema de Directorios ##

El formato de directorios utilizados en el repositorio será el siguiente:

![](http://i65.tinypic.com/153s9oy.png)

Donde en las carpeta denominada main se guardará el código fuente principal, y en las carpeta test, los relacionados a los Unit Test.
Luego en la carpeta docs del proyecto, se almacenarán todos los documentos relacionados al proyecto. Adicionalmente se encontrará una carpeta llamada diagramas, donde estarán alojados todos los diagramas utilizados en el proyecto.

## 5. Equipos del Proyecto ##

El siguiente documento muestra los diferentes equipos dentro del proyecto y sus tareas relacionadas:

- **Scrum Teams**: están a cargo de desarrollar nuevas características y funcionalidades a través de la modificación del código fuente y su posterior merge con la rama principal. Estos mismos también se pueden dedicar a la corrección de errores o bugs.

- **Release Management Team**: se encargan de llevar a cabo todas las pruebas necesarias para comprobar que todos los requerimientos predeterminados para el release hayan sido cumplidos.

- **Product Documentation Team**: este equipo es responsable de crear y mantener la documentación del producto que se entrega al cliente. Una parte de la documentación que está integrada en los repositorios de código fuente y otra parte se entrega junto al producto. Ejemplo de archivos que gestionan: Guía de administración, Guía del usuario, etc.

## 6. Gestión de configuración de código fuente ##

En esta sección se describen distintos ítems de gestion del codigo fuente. Cubre algunos aspectos sobre esquemas de ramas, etiquetas, estrategias de merge y niveles de calidad esperados para todo el producto.

### 6.1. Definiciones y estrategias ###

#### 6.1.1. Definición de las Ramas ####

Los tipos de ramas que van a ser usadas se definen a continuación:

- **Master**: En la rama principal se colocará todo el avance del proyecto, incluido los avances de otras ramas.

- **Versions**: En las ramas de versiones, se colocaran solo correcciones de bugs y features pedidos por clientes que posean esas versiones. El formato de nombre de estas ramas será
<'numero de mayor version.x.x'>-rel.

![](http://i68.tinypic.com/2efq8hy.png)

#### 6.1.2. Definición de las Etiquetas ####

- **Etiquetas de Merges**: Serán aplicadas cada vez que se realice un merge a la rama principal, siempre y cuando sea desde una build estable. El formato será merge-from-<'Version'>.
- **Etiquetas de Build de Release**: Se aplicarán cada vez que una build de release es creada, esto conlleva que haya pasado la compilación y los unit test proveídos por travis-ci. El formato será <'Proyecto'>-<'version'>--<'build id'>.

#### 6.1.3. Archivos Auxiliares de CM ####

Release_Notes.md: Este archivo, contendrá:

- Breve listado de la funcionalidad incluida (con el estado de implementación de c/u).
- Pass/Fail Ratio de sistema.
- Bugs conocidos (i.e. no resueltos) en la entrega.
- Lugar/link del entregable y de las instrucciones de instalación.

Ejempo:


> Fecha: 2011/05/10  
> author: <nombre-del-desarrollador>  
> version: <numero-de-version>  
> 
> funcionalidad incluida: Nueva vista del sistema  
> pass ratio: 73%
> 
> Bugs conocidos: No funciona el botón start  
> Comentarios: <comentarios-adicionales>

#### 6.1.4 Estrategia de merge ####

Los merges deberán llevar una etiqueta de que indique la proveniencia del merge, a su vez estos se realizarán solo con builds estables. La etiqueta tendrá el formato: merge-from-<'etiqueta-de-build'>.

#### 6.1.5. Estrategia de Commits ####

Los commits contendrán una breve descripción de los cambios agregados al proyecto, corrección de bugs o implementación de nuevos features. Ejemplo:
    “Se agrego la funcion suma y resta en clase calculadora”
    “Se implemento corrección a la función suma”.

## 7. Issues Management ##

La herramienta de gestión de defectos utilizada será GitHub. En el momento que es descubierto un defecto, se deberá reportar lo antes posible al gestor de defectos. Para dejar asentado el defecto se utilizará el siguiente formato: <'N°-de-issue'>-<'N°-de-commit'>-<'Pequeña-descripción'>.  
Luego, dentro se especificará mas detalladamente el issue encontrado.  
Una vez solucionado el defecto, se deberá reportar en el gestor indicando el n° de commit en el cual se solucionó.

## 8. Build Management ##

Se utilizará la build de integración continua en las ramas donde se requiera chequear el código continuamente, para evitar errores introducidos durante el desarrollo. El uso de esta build en el proyecto facilitará identificar errores al poco tiempo de haber hecho un commit. La herramienta usada será Travis-ci, donde se podrá ver los Unit Tests corridos, el usuario que hizo el commit entre otros.

## 9. Release Management ##

La build de release será hecha en la misma principal (o rama de versión), luego de pasar los test de travis-ci y una revision de codigo exhaustiva.















