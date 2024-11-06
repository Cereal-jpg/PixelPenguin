<%@ Page Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MatriculaAlumno-1.aspx.cs" Inherits="SoftPixelPenguinsWA.MatriculaAlumno_1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Matrícula - Alumno
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ListarCursos.aspx"><i class="fa-solid fa-book"></i>Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ListarCursos.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaALumno-0.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="PerfilAlumno.aspx"><i class="fa-solid fa-archive"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <style>
        .progress-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin: 20px auto;
            width: 100%;
            max-width: 400px;
        }

        .progress-wrapper {
            display: flex;
            justify-content: center;
        }

        .progress-bar {
            position: absolute;
            top: 50%;
            left: 0;
            height: 4px;
            background-color: #4CAF50;
            z-index: 0;
            transition: width 0.3s ease;
            width: 0%;
        }

        .progress-step {
            width: 30px;
            height: 30px;
            border-radius: 50%;
            background-color: #ccc;
            z-index: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 14px;
            color: white;
        }

        .progress-step.active {
            background-color: #4CAF50;
        }

        .buttons button {
            flex: 1;
            padding: 10px;
            border-radius: 6px;
            border: none;
            background-color: #87CEEB;
            color: white;
            cursor: pointer;
            text-align: center;
        }

        .buttons button:not(:last-child) {
            margin-right: 20px;
        }

        .buttons button:hover {
            background-color: #66B2FF;
        }

        .container-proceso {
            display: flex;
            width: 100%;
            margin-top: 5px;
            background-color: aliceblue;
            padding: 10px;
            box-sizing: border-box;
        }

        .datos-container {
            display: flex;
            flex-wrap: wrap;
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            background-color: #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        .form-Datos-container {
            width: 100%;
        }

        .form-row {
            display: flex;
            width: 100%;
            gap: 10px;
            margin-bottom: 15px;
        }

        .form-group {
            flex: 1;
            min-width: 160px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        .container-boucher{
            align-content: center;
            justify-content: center;
            background-color: azure;
        }

    </style>

    <link rel="stylesheet" href="Content/Estilos-Alumno.css" />
    <script src="Scripts/BarraProgreso.js" type="text/javascript"></script>

    <h2 style="text-align: left; color: #000f; border-bottom: 2px solid #808080;">Matrícula Online</h2>
    <div id="container-proceso" class="container-proceso">
        <div class="matricula-section" style="padding: 5px;">
            <h3 style="border-bottom: 2px solid #ccc">Proceso de matrícula - Actualizar y Validar Datos Personales</h3>
            <div class="progress-wrapper">
                <div class="progress-container">
                    <div class="progress-bar" id="progress-bar"></div>
                    <div class="progress-step active">1</div>
                    <div class="progress-step">2</div>
                    <div class="progress-step">3</div>
                    <div class="progress-step">4</div>
                </div>
            </div>
            <p>Actualiza los datos personales de <nombre> y del apoderado:</p>

            <div class="datos-container">
                <div class="form-Datos-container">
                    <h4 style="width: 100%; font-size: 17px; border-bottom: 2px solid #808080">Datos del Alumno</h4>

                    <!-- Fila con tres campos alineados horizontalmente -->
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input type="text" id="nombre" name="nombre" required />
                        </div>
                        <div class="form-group">
                            <label for="apellido-paterno">Apellido Paterno:</label>
                            <input type="text" id="apellido-paterno" name="apellido-paterno" required />
                        </div>
                        <div class="form-group">
                            <label for="apellido-materno">Apellido Materno:</label>
                            <input type="text" id="apellido-materno" name="apellido-materno" required />
                        </div>
                    </div>

                    <!-- Fila con cuatro campos alineados horizontalmente -->
                    <div class="form-row">
                        <div class="form-group">
                            <label for="dni">DNI:</label>
                            <input type="text" id="dni" name="dni" required />
                        </div>
                        <div class="form-group">
                            <label for="fecha-nacimiento">Fecha de Nacimiento:</label>
                            <input type="date" id="fecha-nacimiento" name="fecha-nacimiento" required />
                        </div>
                        <div class="form-group">
                            <label for="sexo">Sexo:</label>
                            <input type="text" id="sexo" name="sexo" required />
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email" required />
                        </div>
                    </div>
                </div>
            </div>

            <div class="buttons">
                <button onclick="prevStep()">Anterior</button>
                <button>Guardar</button>
                <button>Editar</button>
                <button onclick="nextStep2()">Grabar y Continuar</button>
            </div>
        </div>
    </div>

    <script>
        function nextStep2() {
            const container = document.getElementById('container-proceso');
            const inputs = document.querySelectorAll('input'); // Selecciona todos los inputs
            let allFilled = true; // Variable para validar si todos los inputs están llenos

            // Recorre todos los inputs y verifica si están vacíos
            inputs.forEach(input => {
                if (!input.value) {
                    allFilled = false; // Si algún input está vacío, cambia a false
                    input.style.borderColor = 'red'; // Resalta el input vacío
                } else {
                    input.style.borderColor = ''; // Restablece el color del borde si está lleno
                }
            });

            // Si todos los inputs están llenos, cambia el contenido del contenedor
            if (allFilled) {
                // Cambia el contenido del contenedor al siguiente paso
                container.innerHTML = `
                <div class="matricula-section" style="padding: 5px;">
        <h3 style="border-bottom: 2px solid #ccc; width:100%">Proceso de matrícula - Certificados</h3>
        <div class="progress-wrapper">
            <div class="progress-container">
                <div class="progress-bar" id="progress-bar"></div>
                <div class="progress-step active">1</div>
                <div class="progress-step active">2</div>
                <div class="progress-step">3</div>
                <div class="progress-step">4</div>
            </div>
        </div>
        <p>Valida y, si es necesario, actualiza los certificados correspondientes de ALFREDO ERNESTO SANCHEZ TUESTA.</p>

        <div class="datos-container">
            <h4 style="font-size: 17px; border-bottom: 2px solid #808080; width:100%;">Adjuntar Certificados</h4>

            <!-- Certificado de Estudios -->
            <div class="form-row">
                <div class="file-input-group">
                    <label for="certificado-estudios" style="width:100%; display:block;">Adjuntar Certificado de Estudios:</label>
                    <input type="file" id="certificado-estudios" name="certificado-estudios" style="background-color: white; border-radius: 5px; width: 100%; box-sizing: border-box;" />
            </div>
            </div>

            <!-- Certificado de Salud -->
            <div class="form-row">
                <div class="file-input-group">
                <label for="certificado-salud">Adjuntar Certificado de Salud:</label>

                    <input style="background-color:white; border-radius:5px; width:100%;" type="file" id="certificado-salud" name="certificado-salud" />
                </div>
            </div>
        </div>

        <div class="buttons">
            <button onclick="prevStep()">Atrás</button>
            <button>Guardar</button>
            <button>Editar</button>
            <button onclick="nextStep3()">Grabar y Continuar</button>
        </div>
    </div>
</div>
            `;
            } else {
                alert('Por favor, complete todos los campos antes de continuar.'); // Mensaje de error
            }
            
        }


        function nextStep3() {
            const container = document.getElementById('container-proceso');

            // Cambia el contenido del contenedor al siguiente paso
            container.innerHTML = `
                <div class="matricula-section" style="padding: 5px;">
        <h3 style="border-bottom: 2px solid #ccc; width:100%">Proceso de matrícula - Boucher de Pago</h3>
        <div class="progress-wrapper">
            <div class="progress-container">
                <div class="progress-bar" id="progress-bar"></div>
                <div class="progress-step active">1</div>
                <div class="progress-step active">2</div>
                <div class="progress-step active">3</div>
                <div class="progress-step">4</div>
            </div>
        </div>
        <p>Realice el pago correspondiente de la matrícula para continuar con el proceso de matrícula</p>

        <div class="datos-container">
            <h4 style="font-size: 17px; border-bottom: 2px solid #808080; width:100%;">Adjuntar Boucher del pago</h4>
            <p style="width: 100%; margin: 0;">Debe realizar el pago correspondiente de la matrícula para continuar con el proceso de matrícula.</p>
            <div class="container-Boucher" style="background-color: #f0f0f0; padding: 10px; border-radius: 5px; margin: 10px auto; width: 300px; text-align: center;">
                <p>Cuenta Bancaria a depositar:</p>
                <p>XXXX-XXXX-XXXXXXXXXX</p>
            </div>
            <!-- Boucher de Pago -->
            <div class="form-row">
                <div class="file-input-group">
                <label for="boucher-pago">Adjuntar Boucher de Pago:</label>

                    <input style="background-color:white; border-radius:5px; width:100%;" type="file" id="boucher-pago" name="boucher-pago" />
                </div>
            </div>
        </div>

        <div class="buttons">
            <button onclick="prevStep()">Atrás</button>
            <button>Guardar</button>
            <button>Editar</button>
            <button onclick="nextStep4()">Grabar y Continuar</button>
        </div>
    </div>
</div>
            `;
        }

        function nextStep4() {
            const container = document.getElementById('container-proceso');

            // Cambia el contenido del contenedor al siguiente paso
            container.innerHTML = `
            <div class="matricula-section" style="padding: 5px;">
                <h3 style="border-bottom: 2px solid #ccc; width:100%">Proceso de matrícula - Terminar Proceso</h3>
                <div class="progress-wrapper">
                    <div class="progress-container">
                        <div class="progress-bar" id="progress-bar"></div>
                        <div class="progress-step active">1</div>
                        <div class="progress-step active">2</div>
                        <div class="progress-step active">3</div>
                        <div class="progress-step active">4</div>
                    </div>
                </div>
                <p style="text-align:center;">Gracias por concluir con los pasos correspondientes para el proceso de matrícula. Usted ha sido matriculado en el periodo 2025 con éxito. Se le enviará un correo con toda la información de su matrícula.</p>

                <div class="buttons">
    <asp:Button ID="btnTerminarProceso" runat="server" Text="Terminar proceso de matrícula"
            OnClick="btnTerminarProceso_Click"
            style="background-color: #87CEEB; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; margin: 10px auto;" />
</div>
            </div>
        `;
        }
    </script>
</asp:Content>
