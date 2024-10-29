<%@ Page Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MatriculaAlumno-1.aspx.cs" Inherits="SoftPixelPenguinsWA.MatriculaAlumno_1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Matrícula - Alumno
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <style>
        .progress-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin: 20px auto; /* Centra horizontalmente */
            width: 100%;
            max-width: 400px;
        }

        .progress-wrapper {
            display: flex;
            justify-content: center; /* Centra el contenedor internamente */
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
                flex: 1; /* Hace que todos los botones ocupen el mismo ancho */
                padding: 10px;
                border-radius: 6px;
                border: none;
                background-color: #87CEEB; /* Color celeste */
                color: white;
                cursor: pointer;
                text-align: center;
                margin: 0; /* Elimina márgenes laterales */
            }

                .buttons button:not(:last-child) {
                    margin-right: 20px; /* Añade espacio entre botones, excepto el último */
                }

                .buttons button:hover {
                    background-color: #66B2FF; /* Color al hacer hover */
                }

        .container-proceso {
            display: flex; /* Usar flexbox para organizar el layout */
            width: 100%; /* Ancho completo */
            margin-top: 5px; /* Espacio arriba */
            background-color: aliceblue;
            padding: 10px;
            box-sizing: border-box; /* Incluye el padding en el ancho total */
        }

        .datos-container {
            display: flex; /* Usar flexbox para organizar el layout */
            width: 100%; /* Ancho completo */
            padding: 10px;
            margin-top: 5px; /* Espacio arriba */
            background-color: #ccc;
            border-radius: 6px;
            box-sizing: border-box; /* Incluye el padding en el ancho total */
        }

        .form-Datos-container{
            width: 100%;
        }

    </style>
    <link rel="stylesheet" href="Content/Estilos-Alumno.css" />
    <script src="Scripts/BarraProgreso.js" type="text/javascript"></script>
    <h2 style="text-align: left; color: #000f; border-bottom: 2px solid #808080;">Matrícula Online</h2>
    <div class="container-proceso">
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
            <p>Actualiza los datos personales de
                <nombre>
                y del apoderado:</p>
            <div class="datos-container">
                <div class="form-Datos-container">
                    <h4 style="width: 100%; font-size: 17px; border-bottom: 2px solid #808080">Datos del Alumno</h4>
                    <div class="form-group"></div>
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" required />
                </div>
            </div>
            <div class="buttons">
                <button onclick="prevStep()">Anterior</button>
                <button>Guardar</button>
                <button>Editar</button>
                <button onclick="nextStep()">Grabar y Continuar</button>
            </div>
        </div>
    </div>
</asp:Content>
