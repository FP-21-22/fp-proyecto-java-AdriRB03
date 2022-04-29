# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21/22)
Autor/a: Adrián Robles Borrego  uvus:adrrobbor126

Tuve una tutoria con usted el lunes porque habia tenido un problema al subir el poyecto a github y me dijo que lo subiera despues de fecha con esta aclaracion en el Readme. 

Al final era lo que deciamos, que el token estaba caducado desde el 17 de enero y por eso no me dejaba subirlo.


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.clinico**: Paquete que contiene los tipos Persona, Paciente y PacienteEstudio.
  * **fp.farmaceutico**: Paquete que contiene los tipos Medicamento y FactoriaMedicamentos
  * **fp.farmaceutico.test**: Paquete que contiene el tipo TestFactoriaMedicamentos
  * **fp.vacunas**: Paquete que contiene el tipo Vacunacion.
  * **fp.utiles**:  Paquete que contiene la clase de Checkers. 
* **/README**: Contiene la organizacion del proyecto y como esta dividido.    
    

## Tipos implementados

### Tipo Persona
El tipo persona crea una persona con nombre, apellidos, dni y fecha de nacimiento.

**Propiedades**:
SString nombre, String apellidos, String dni, LocalDate fechaNacimiento
- Propiedad 1: de tipo String, representa el nombre de la persona. 
- Propiedad 2: de tipo String, representa los apellidos de la persona.
- Propiedad 3: de tipo String, representa el dni de la persona.
- Propiedad 4: de tipo LocalDate, representa la fecha de nacimiento de la persona.


**Restricciones**:
 
- R1: Comprueba que la fecha de nacimiento sea anterior a la fecha actual.
- R2: Comprueba que el dni tenga longitud 9.
- R3: Comprueba que el dni tenga numeros del 0 al 9.
- R4: Comprueba que el ultimo digito es un caracter.

**Criterio de igualdad**: No tiene.

**Criterio de ordenacion**: Lo ordena por dni.

**Tipos auxiliares**
- Metodo 1: llamado edad(), obtiene la edad de la persona.

**Factoria**
- Parse: Obtiene una cadena con formato y devuelve una persona
- Of: Obtiene nombre, apellidos, dni y fecha de nacimiento y devuelve una persona.

### Tipo Paciente
 El tipo paciente crea un paciente con nombre, apellidos, fecha de nacimiento, codigo de ingreso y fecha y hora

**Propiedades**:
Persona persona,String nombre, String apellidos, String dni, LocalDate fechaNacimiento,String codigoDeIngreso,LocalDateTime fechaYHora.
- Propiedad 1: de tipo String, representa el nombre de la persona. 
- Propiedad 2: de tipo String, representa los apellidos de la persona.
- Propiedad 3: de tipo String, representa el dni de la persona.
- Propiedad 4: de tipo LocalDate, representa la fecha de nacimmiento de la persona.
- Propiedad 5: de tipo String, representa el codigo de ingreso
- Propiedad 6: de tipo LocalDateTime, representa la fecha y la hora


**Restricciones**:
 - R1: Comprueba que la fecha de nacimiento sea anterior a la fecha actual.
- R2: Comprueba que el dni tenga longitud 9.
- R3: Comprueba que el dni tenga numeros del 0 al 9.
- R4: Comprueba que el ultimo digito es un caracter.

**Criterio de igualdad**: No tiene.

**Criterio de ordenacion**: No tiene.

**Tipos auxiliares**
- Metodo 1: llamado fechaDeIngreso(), obtiene la fecha en el que el paciente ingresó.
- Metodo 1: llamado horaDeIngreso(), obtiene la hora en el que el paciente ingresó..

**Factoria**
- Of: Obtiene persona, codigoDeIngreso y fechaYHora y devuelve una persona.
- Of: Obtiene nombre, apellidos, dni, fecha de nacimiento, codigoDeIngreso y fechaYHora y devuelve una persona.

### Tipo PacienteEstudio
El tipo PacienteEstudio crea un paciente con id y edad

**Propiedades**:
String id, String genero, Double edad, Boolean hipertension, Boolean enfermedadDelCorazon, TipoResidencia tipoDeResidencia, Double nivelMedioDeGlucosa
- Propiedad 1: de tipo String, representa el id de la persona. 
- Propiedad 2: de tipo String, representa el genero de la persona.
- Propiedad 3: de tipo Double, representa el dni de la persona.
- Propiedad 4: de tipo Boolean, representa si el paciente tiene o no hipertension.
- Propiedad 5: de tipo Boolean, representa si el paciente tiene o no una enfermedad del corazon.
- Propiedad 6: de tipo TipoResidencia, puede tomar los valores de rural o urbana
- Propiedad 7: de tipo Double, representa el nivel medio de glucosa.



**Restricciones**:
 
- R1: Comprueba que la edad tiene que ser mayor o igual que cero y menor o igual que 130.
- R2: Comprueba que el nivel medio de glucosa tiene que ser mayor o igual que cero.


**Criterio de igualdad**: No tiene.

**Criterio de ordenacion**: Lo ordena por la edad y el id.

**Tipos auxiliares**
- Metodo 1: llamado factorDeRiesgo(), si el paciente tiene hipertensión y más de 40 años se considera que tiene factor de riesgo

**Factoria**
- Parse: Obtiene una cadena con formato y devuelve un paciente
- Of: Obtiene todas las propiedades basicas y devuelve un paciente.

### Tipo Vacunacion
El tipo Vacunacion crea una vacunacion con fecha, comunidad, el numero de vacunas de cada tipo que tiene puesta la persona y el numero de personas que participan.

**Propiedades**:
LocalDate fecha, String comunidad, Integer pfizer, Integer moderna, Integer astrazeneca, Integer janssen, Integer numeroDePersonas
- Propiedad 1: de tipo LocalDate, representa la fecha de vacunacion. 
- Propiedad 2: de tipo String, representa la comunidad en la que vive la persona.
- Propiedad 3: de tipo Integer, representa el numero de dosis de pfizer.
- Propiedad 4: de tipo Integer, representa el numero de dosis de moderna
- Propiedad 5: de tipo Integer, representa el numero de dosis de astrazeneca
- Propiedad 6: de tipo Integer, representa el numero de dosis de janssen
- Propiedad 7: de tipo Integer, representa numero total de personas que participan en la vacunacion.


**Restricciones**:
 
- R1: Comprueba que la fecha sea posterior al 01/02/2021.


**Criterio de igualdad**: No tiene.

**Criterio de ordenacion**: por comunidad y en caso de igualdad por fecha

**Tipos auxiliares**
- Metodo 1: llamado numeroTotal(), representa el numero total de vacunas que tienen puestas cada persona.

**Factoria**
- Parse: Obtiene una cadena con formato y devuelve una persona
- Of: Obtiene todas las propiedades basicas y devuelve una persona.


### Tipo Medicamento
El tipo persona crea una persona con nmbre, apellidos y fecha de nacimiento.

**Propiedades**:
String nombreDelMedicamento, TipoMedicamento tipoMedicamento,String codigoDeLaEnfermedad, String farmaceutica,Double puntuacion, Integer indiceSomatico, LocalDate fechaDeCatalogo
String nombre, String apellidos, String dni, LocalDate fechaNacimiento
- Propiedad 1: de tipo String, representa el nombre del medicamento. 
- Propiedad 2: de tipo TipoMedicamento, puede tomar los valores de anatómico, químico y terapéutico
- Propiedad 3: de tipo String, representa el codigo de la enfermedad
- Propiedad 4: de tipo String, representa el nombre de la farmaceutica
- Propiedad 5: de tipo Double, representa la puntuacion obtenida del medicamento.
- Propiedad 6: de tipo Integer, representa el numero de indice somatico
- Propiedad 7: de tipo LocalDate, representa la fecha en que se catalogó el medicamento.


**Constructores**: 

- C1: Obtiene todas las propiedades basicas.


**Restricciones**:
 
- R1: Comprueba que la puntuacion debe de ser mayor que 0.
- R2: Comprueba que el índice somático tiene que ser mayor o igual que 1000
- R3: Comprueba que la fecha de catálogo tiene que ser posterior al 01/01/2015.


**Criterio de igualdad**: por nombre del medicamento y farmacéutica.

**Criterio de ordenacion**: por nombre del medicamento y en caso de igualdad por la farmacéutica.

**Tipos auxiliares**
- Metodo 1: llamado edad(), obtiene la edad de la persona.

**Comentarios**
- Creo ademas una clase de nombre FactoriaMedicamentos que incluye un
método estatico de nombre parseaMedicamento, que recibe una cadena con un
formato específico y devuelve un objeto de tipo Medicamento.
- Finalmente implemento una clase de nombre TestFactoriaMedicamentos que comprueba el correcto funcionamiento del método anterior.


### Factoría - FactoriaVacunación
Clase de factoría para construir objetos de tipo Vacunacion.

Metodos:

- leeFichero(String nombreFichero): Dada una cadena con el nombre del fichero, devuelve una lista de objetos Vacunacion.

- parse(String text): parsea cada linea del fichero.

Además, se ha creado una clase llamada TestFactoriaVacunacion, en la que se prueba el funcionamiento correcto de la clase FactoriaVacunacion.

### Factoría - FactoriaMedicamentos2
Clase de factoría para construir objetos de tipo Medicamento.

Metodos:

- leeFichero(String nombreFichero): Dada una cadena con el nombre del fichero, devuelve una lista de objetos Medicamento.

- parseaMedicamento(String text): parsea cada linea del fichero.

Además, se ha creado una clase llamada TestFactoriaMedicamentos2, en la que se prueba el funcionamiento correcto de la clase FactoriaMedicamentos2.


## Interfaz implementada
Llamada EstudioClinico, incorporada en el paquete fp.clinico. 

Esta interfaz tiene dos implementaciones, una imperativa, llamada EstudioClinicoBucles y otra funcional, llamada EstudioCLinicoStream.
 
Contiene Los siguientes metodos:




 
- Propiedades de lista

	Integer numeroPacientes(): obtiene el numero de pacientes total.
	
	void incluyePaciente(PacienteEstudio paciente): se utiliza para incluir un paciente a la lista.
	
	void incluyePacientes(Collection<PacienteEstudio> pacientes): incluye varios pacientes.
	
	void eliminaPaciente(PacienteEstudio paciente):se utiliza para eliminar un paciente.
	
	Boolean estaPaciente(PacienteEstudio paciente): devuelve true si el paciente esta en el fichero, y false si no esta.
	
	void borraEstudio(): borra el estudio completo
	 
- Método de factoría

	EstudioClinico of(String nombreFichero): hace una llamada la metodo leeFichero, y construye un objeto de tipo EstudioClinico
	
	List<PacienteEstudio> leeFichero(String nombreFichero): metodo que sirve para la lectura del fichero de texto.
	
- Tratamientos secuenciales: implementaciónn funcional vs. imperativa

	 Boolean todosPacienteSonDelTipo(TipoResidencia tipo): devuelve true si todos los pacientes son del tipo TipoResidencia, y false si no lo son.
	 
	 Boolean existeAlgunPacienteDelTipo(TipoResidencia tipo): devuelve true si existe algun paciente de tipo TipoResidencia, y false si no existe.
	 
- Contador, suma, media

	 Integer numeroPacientesFactorRiesgo(): devuelve un entero que smboliza el numero de pacientes con factor de riesgo.i

	 Double edadMediaPacientesConFactorRiesgo(): devuelve un Double que simboliza la edad media de los pacientes que presentan factor de riesgo.;
	 
- Filtradoo

	 List<PacienteEstudio> filtraPacientesPorEdad(Double edad): devuelve una lista que filtra los pacientes por edad.
	 
	 Map<String,List<PacienteEstudio>> agruparPacientesEdadMayorQuePorGenero(Double edad): devuelve un mapa que agrupa los pacientes de edad mayor por genero.
	 
	 Map<String,Long> numeroPacientesPorGenero(): devuelve un mapa que obtiene el numero de paciente por genero.
	 
	 Map<String,Double> edadMediaPacientesPorPorGenero(): devuelve un mapa que obtiene la edad media de los pacinetes dependiendo del genero.


**EstudioClinicoBucles**:

Esta clase implementa todos los metodos de la interfaz de forma imperativa.

**EstudioClinicoStream**:

Esta clase implementa todos los metodos de la interfaz de forma funcional.




