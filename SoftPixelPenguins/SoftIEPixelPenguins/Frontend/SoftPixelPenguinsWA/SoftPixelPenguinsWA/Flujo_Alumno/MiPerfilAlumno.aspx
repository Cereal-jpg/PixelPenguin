
<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MiPerfilAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.MiPerfilAlumno" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mi Perfil - Alumno
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i> Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="MisCursosAlumno.aspx"><i class="fa-solid fa-book"></i> Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i> Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaOnlineAlumno.aspx"><i class="fa-solid fa-archive"></i> Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="MisPagosAlumno.aspx"><i class="fa-solid fa-book"></i> Mis Pagos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i> Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <style>
        /* Responsive and improved styling */
        .profile-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        .form-section {
            background-color: #f9f9f9;
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .form-group {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }

        .form-row {
            flex: 1;
            min-width: 250px;
            margin-bottom: 15px;
        }

        .form-row label {
            display: block;
            margin-bottom: 5px;
            font-weight: 600;
            color: #333;
        }

        .form-row input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            transition: border-color 0.3s ease;
        }

        .form-row input:focus {
            outline: none;
            border-color: #007bff;
        }

        .input-group {
            position: relative;
        }

        .input-icon {
            position: absolute;
            right: 10px;
            top: 50%;
            transform: translateY(-50%);
            cursor: pointer;
        }

        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .button-style {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 12px 24px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .button-style:hover {
            background-color: #0056b3;
        }

        @media (max-width: 768px) {
            .form-row {
                min-width: 100%;
            }

            .form-group {
                flex-direction: column;
            }
        }
    </style>

    <script src="/Scripts/MostrarContraseña.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const togglePassword = document.querySelector('#togglePassword');
            const passwordField = document.querySelector('#<%= txtContrasena.ClientID %>');

            togglePassword.addEventListener('click', function (e) {
                // Toggle password visibility
                const type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
                passwordField.setAttribute('type', type);
                // Toggle eye icon
                this.classList.toggle('fa-eye-slash');
            });
        });
    </script>

    <div class="profile-container">
        <h2 class="page-title">Mi Perfil</h2>

        <div id="section1" class="section" runat="server" style="display: block;">
            <div class="form-section">
                <h2>Datos del Alumno</h2>
                <div class="form-group">
                    <div class="form-row">
                        <label>Nombres:</label>
                        <asp:TextBox ID="txtNombreAlumno" runat="server" placeholder="Nombres"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Apellido Paterno:</label>
                        <asp:TextBox ID="txtApellidoPaterno" runat="server" placeholder="Apellido Paterno"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Apellido Materno:</label>
                        <asp:TextBox ID="txtApellidoMaterno" runat="server" placeholder="Apellido Materno"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>DNI:</label>
                        <asp:TextBox ID="txtDNIAlumno" runat="server" placeholder="DNI"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Fecha de Nacimiento:</label>
                        <asp:TextBox ID="dtpFechaNacimiento" runat="server" placeholder="Fecha de Nacimiento" CssClass="date-picker" TextMode="Date"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Sexo:</label>
                        <asp:TextBox ID="txtSexo" runat="server" placeholder="Sexo"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Email:</label>
                        <asp:TextBox ID="txtEmail" runat="server" placeholder="Email"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Direccion:</label>
                        <asp:TextBox ID="txtDireccion" runat="server" placeholder="Direccion"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Usuario:</label>
                        <asp:TextBox ID="txtUsuario" runat="server" placeholder="Usuario"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Contraseña:</label>
                        <div class="input-group">
                            <asp:TextBox ID="txtContrasena" runat="server" placeholder="Contraseña" TextMode="Password" CssClass="form-control password-field"></asp:TextBox>
                            <span class="input-icon">
                                <i class="fa fa-eye" id="togglePassword" style="cursor: pointer;"></i>
                            </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-section">
                <h2>Datos del Apoderado</h2>
                <div class="form-group">
                    <div class="form-row">
                        <label>DNI:</label>
                        <asp:TextBox ID="txtDNIApoderado" runat="server" placeholder="DNI"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Nombre Completo:</label>
                        <asp:TextBox ID="txtNombreApoderado" runat="server" placeholder="Nombre completo"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Teléfono:</label>
                        <asp:TextBox ID="txtTelefonoApoderado" runat="server" placeholder="Teléfono"></asp:TextBox>
                    </div>
                    <div class="form-row">
                        <label>Relacion:</label>
                        <asp:TextBox ID="txtRelacionApoderado" runat="server" placeholder="Relacion"></asp:TextBox>
                    </div>
                </div>
            </div>

            <div class="form-section">
                <h2>Certificados</h2>
                <div class="form-group">
                    <div class="form-row">
                        <label>Certificado de Estudios:</label>
                        <asp:LinkButton ID="linkDescargarEstudios" runat="server" CssClass="btn btn-info" OnClick="linkDescargarEstudios_Click">
                            Descargar Certificado de Estudios
                        </asp:LinkButton>
                    </div>
                    <div class="form-row">
                        <label>Certificado de Salud:</label>
                        <asp:LinkButton ID="linkDescargarSalud" runat="server" CssClass="btn btn-info" OnClick="linkDescargarSalud_Click">
                            Descargar Certificado de Salud
                        </asp:LinkButton>
                    </div>
                </div>
            </div>

            <div class="button-container">
                <asp:Button ID="btnGuardar" runat="server" Text="Guardar Cambios" OnClick="btnGuardar_Click1" CssClass="button-style" />
            </div>
        </div>
    </div>
</asp:Content>
