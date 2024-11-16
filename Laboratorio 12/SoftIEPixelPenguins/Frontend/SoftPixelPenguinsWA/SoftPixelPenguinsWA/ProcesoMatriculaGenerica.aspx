<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ProcesoMatriculaGenerica.aspx.cs" Inherits="SoftPixelPenguinsWA.ProcesoMatriculaGenerica" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pixel Penguins - Matrícula</title>
    <link rel="icon" type="image/png" href="Images/PIXEL2.png" />
    <link rel="stylesheet" href="Content/Estilos.css" />
    <link rel="stylesheet" href="Content/Estilos-ProcesoMatriculaG.css" />
    <link rel="stylesheet" href="../Content/EstilosMatriculaG.css" />
</head>
<body>
    <form id="form1" runat="server">
            <div class="header">
                <img src="Images/PIXEL.png" alt="Logo" />
                <h1>Pixel Penguins</h1>
                <div class="nav">
                    <a href="Login.aspx">Intranet</a>
                    <a href="Matricularse.aspx">Matrícula</a>
                </div>
            </div>
            <div id="registrarUsuario" runat="server" class="container">
                <h2 class="titulo">Proceso de matrícula</h2>
                <hr>
                <p>Inicia tu proceso de matrícula 2025 y descubre con nosotros lo increíble que es aprender. Registrate ingresando tus datos para que puedas comenzar tu proceso de matrícula.</p>
                <br>


                <div id="section1" class="section" runat="server" style="display: block;">
                    <div class="form-section">
                        <h3>Datos del alumno</h3>
                        <hr>
                        <div class="form-group">
                            <div class="form-row">
                                <label>Nombres:</label>
                                <asp:TextBox ID="txtNombreAlumno" runat="server" placeholder="Nombres" required="required" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="form-row">
                                <label>Apellido Paterno:</label>
                                <asp:TextBox ID="txtApellidoPaterno" runat="server" placeholder="Apellido Paterno" required="required" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="form-row">
                                <label>Apellido Materno:</label>
                                <asp:TextBox ID="txtApellidoMaterno" runat="server" placeholder="Apellido Materno" required="required" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <label>DNI:</label>
                                <asp:TextBox ID="txtDNIAlumno" runat="server" placeholder="DNI" required="required" CssClass="form-control"></asp:TextBox>
                            </div>
                            <div class="form-row">
                                <label>Fecha de Nacimiento:</label>
                                <asp:TextBox ID="dtpFechaNacimiento" runat="server" placeholder="Fecha de Nacimiento" CssClass="date-picker form-control" TextMode="Date" required="required"></asp:TextBox>
                            </div>
                            <div class="form-row">
                                <label for="ddlSexo">Sexo:</label>
                                <asp:DropDownList ID="ddlSexo" runat="server" CssClass="form-control custom-dropdown" required="required">
                                    <asp:ListItem Text="Seleccionar" Value="" />
                                    <asp:ListItem Text="Masculino" Value="Masculino" />
                                    <asp:ListItem Text="Femenino" Value="Femenino" />
                                </asp:DropDownList>
                            </div>
                            <div class="form-row">
                                <label>Email:</label>
                                <asp:TextBox ID="txtEmail" runat="server" placeholder="Email" required="required" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <label>Direccion:</label>
                                <asp:TextBox ID="txtDireccion" runat="server" placeholder="Direccion" required="required" CssClass="form-control"></asp:TextBox>
                            </div>
                        </div>
                    </div>
                    <div class="button-container">
                        <asp:Button ID="btnRegistrar" runat="server" Text="Registrarse" CssClass="button-container" OnClick="btnRegistrar_Click"/>
                    </div>
                </div>
            </div>

            <div id="registrarLogin" runat="server" class="container">
                <h2 class="titulo">Proceso de matrícula</h2>
                <hr>
                <p>Usted ha sido registrado exitosamente. Se le ha enviado un correo en el que están sus datos para ingresar a su cuenta.</p>
                <br>
                <div class="button-container">
                    <asp:Button ID="btnVolverLogin" runat="server" Text="Iniciar Sesión" CssClass="button-container" OnClick="btnVolverLogin_Click"/>
                </div>
            </div>
    </form>
</body>
</html>







































































