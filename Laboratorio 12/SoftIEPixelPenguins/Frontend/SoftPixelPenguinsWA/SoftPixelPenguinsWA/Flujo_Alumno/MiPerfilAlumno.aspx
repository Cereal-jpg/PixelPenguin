<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="MiPerfilAlumno.aspx.cs" Inherits="SoftPixelPenguinsWA.MiPerfilAlumno" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mi Perfil - Alumno
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
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
    <link href="Content/Estilos-Perfil.css" rel="stylesheet" />
    <script src="/Scripts/MostrarContraseña.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const togglePassword = document.querySelector('#togglePassword');
            const passwordField = document.querySelector('#<%= txtContrasena.ClientID %>');

                togglePassword.addEventListener('click', function (e) {
                    // Cambia el atributo type
                    const type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
                    passwordField.setAttribute('type', type);
                    // Cambia el ícono
                    this.classList.toggle('fa-eye-slash');
                });
            });
    </script>


    <h2 style="text-align: left; color: #000f;">Alumno - Mi Perfil</h2>
    <link rel="stylesheet" href="Content/Estilos-Alumno.css" />

    <div class="schedule">
        <div id="section1" class="section" runat="server" style="display: block;">

            <div class="form-section">
                    <h3>Datos del alumno</h3>
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
                    </div>
                    <div class="form-group">
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
                    </div>
                    <div class="form-group">
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
                    <h3>Datos del Apoderado</h3>
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
                    <h3>Certificados</h3>
                    <div class="form-group">
                        <div class="form-row">
                            <label>Certificado de Estudios:</label>
                            <asp:LinkButton ID="linkDescargarEstudios" runat="server" CssClass="btn btn-info me-2" OnClick="linkDescargarEstudios_Click">
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

                <div class="button-group">
                    <asp:Button ID="btnGuardar" runat="server" Text="Guardar Cambios" OnClick="btnGuardar_Click1" CssClass="button-style" />
                </div>

            </div>
    
        </div>

</asp:Content>
