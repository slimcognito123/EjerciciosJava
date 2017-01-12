/** Comprobaciones de que el usuario introduce información válida para el registro**/


		var errorNombre;
		var errorPasswordLen;
		var errorPasswordCoin;
		var nombreUsuario;
		var password1;
		var password2;


		function comprobarNombre(){
			//Nombre de usuario tiene más de dos caracteres diferentes a espacios
			var nombreUsuario = document.getElementById("nombreUsuarioR").value;
			var nombreUsuarioSin = nombreUsuario.trim();
			if (nombreUsuarioSin.length < 2){
				errorNombre = "El nombre de usuario debe ser mayor de dos caracteres y sin espacios";
				document.getElementById("errorNombre").innerHTML = errorNombre;

			}
			else{
				errorNombre = "";
				document.getElementById("errorNombre").innerHTML = errorNombre;
			}
		}
		function comprobarPasswordLen(){
			//La contraseña debe ser mayor de 6 caracteres
			password1 = document.getElementById("passwordR").value;
			if (password1.length < 6){
				errorPasswordLen = "La contraseña debe ser mayor de 6 caracteres";
				document.getElementById("errorPWleng").innerHTML = errorPasswordLen;
			}
			else{
				errorPasswordLen = "";
				document.getElementById("errorPWleng").innerHTML = errorPasswordLen;
			}
		}
		function comprobarPasswordIgual(){
			password1 = document.getElementById("passwordR").value;
			password2 = document.getElementById("passwordRR").value;
			if (password1 !== password2){
				errorPasswordCoin = "La contrseña debe ser la misma en los dos inputs";
				document.getElementById("errorPWcoin").innerHTML = errorPasswordCoin;
			}
			else{
				errorPasswordCoin = "";
				document.getElementById("errorPWcoin").innerHTML = errorPasswordCoin;
			}
		}
		
		function habilitarBoton(){
			//Cuando no hay errores en el formulario se habilita el boton registrarse
			if (errorNombre.length == 0 && errorPasswordLen.length == 0 && errorPasswordCoin.length == 0){
				document.getElementById("botonRegistro").disabled = false;
				console.log("entra");
			}
			else{
				console.log("no entra");
			}
		}



