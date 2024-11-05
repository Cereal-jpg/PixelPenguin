<%@ Page Title="Detalle de Solicitudes" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="GestionarSolicitudes_VerDetalle.aspx.cs" Inherits="SoftPixelPenguinsWA.GestionarSolicitudes_VerDetalle" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión de Usuarios
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="cphScripts" runat="server">
    <style>
        * {
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        .container {
            width: 80%;
            margin: auto;
            margin-top: 50px;
            background-color: #e8f0ff;
            padding: 15px;
            border-radius: 8px;
        }

        .form-section {
            background-color: #cfe2f3;
            padding: 15px;
            padding-top: 5px;
            border-radius: 8px;
        }

        .form-group{
            display: flex;
            width: 100%;
            gap: 10px;
            margin-bottom: 15px;
        }

        .form-row{
            flex: 1;
            min-width: 160px;
        }

        label {
            display: block;
            margin: 10px 0;
            color: black;
        }

        input[type="text"], input[type="date"], input[type="email"], input[type="file"] {
            width: 100%;
            padding: 8px;
            border: none;
            border-radius: 4px;
        }

        .button-container{
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .button-group {
            display:flex;
            gap: 10px;
        }

        .button-style {
            padding: 10px 20px;
            margin: 5px;
            background-color: #666;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        .file-upload {
            display: inline-block;
            width: 100%;
            padding: 10px;
            font-size: 14px;
            color: #555;
            background-color: #f5f5f5;
            border: 1px solid #ccc;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
    </style>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="Index.aspx"><i class="fa-solid fa-home"></i>Pagina principal</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="Reportes.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-search"></i>Busquedas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="GestionarSolicitudes.aspx"><i class="fa-solid fa-plus-circle"></i>Gestionar Solicitudes</a>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="d-flex justify-content-between align-items-center mt-3 mx-3">
        <h1>Gestionar Solicitud</h1>
    </div>
    <hr class="mx-3" />
    <div class="container">
        <div class="main-content">
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
                    <label>GradoAcademico:</label>
                    <asp:TextBox ID="txtGradoAcademico" runat="server" placeholder="Grado Academico"></asp:TextBox>
                </div>
            </div>
            <div class="form-group">
                <div class="form-row">
                    <label>Usuario:</label>
                    <asp:TextBox ID="txtUsuario" runat="server" placeholder="Usuario"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label>Contraseña:</label>
                    <asp:TextBox ID="txtContraseña" runat="server" placeholder="Contraseña"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label>Código:</label>
                    <asp:TextBox ID="txtCodigo" runat="server" placeholder="Código"></asp:TextBox>
                </div>
            </div>
            <div class="form-section">
                <h3>Ver Certificados</h3>
                <div class="form-row">
                    <label>Certificado de Estudios:</label>
                    <asp:LinkButton ID="lnkDescargarEstudios" runat="server" CssClass="btn btn-info me-2" OnClick="lnkDescargarEstudios_Click">
                        Descargar Certificado de Estudios
                    </asp:LinkButton>
                </div>
                <div class="form-row">
                    <label>Certificado de Salud:</label>
                    <asp:LinkButton ID="lnkDescargarSalud" runat="server" CssClass="btn btn-info" OnClick="lnkDescargarSalud_Click">
                        Descargar Certificado de Salud
                    </asp:LinkButton>
                </div>
                <div id="lbBoucherPago" runat="server" class="form-row" style="display: none;">
                    <label>Certificado de Salud:</label>
                    <asp:LinkButton ID="lnkDescargarBoucher" runat="server" CssClass="btn btn-info" OnClick="lnkDescargarBoucher_Click">
                        Descargar Boucher de Pago
                    </asp:LinkButton>
                </div>
            </div>
        </div>
        <div class="button-container">
           <asp:Button ID="btnRegresar" runat="server" Text="Regresar" OnClick="btnRegresar_Click" CssClass="button-style" />
           <div class="button-group">
               <asp:Button ID="btnRechazarSolicitud" runat="server" Text="Rechazar Solicitud" OnClick="btnRechazar_Click" CssClass="button-style" />
               <asp:Button ID="btnConfirmarSolicitud" runat="server" Text="Confirmar Solicitud" OnClick="btnConfirmar_Click" CssClass="button-style" />
           </div>
       </div>
    </div>
 </asp:Content>