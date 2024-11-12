<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="GestionarSolicitudesDetallePA.aspx.cs" Inherits="SoftPixelPenguinsWA.GestionarSolicitudesDetallePA" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestionar Solicitudes
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="../Content/Estilos-GestionarSolDetalleAdmin.css" rel="stylesheet" />
</asp:Content>

<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="IndexPersonalAdministrativo.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ReportesPA.aspx"><i class="fa-solid fa-book"></i>Reportes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="BusquedaPA.aspx"><i class="fa-solid fa-search"></i>Busqueda</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="CursosYHorariosPA.aspx"><i class="fa-solid fa-calendar-days"></i>Cursos y Horarios</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="GestionarSolicitudesPA.aspx"><i class="fa-solid fa-user-plus"></i>Gestionar Solicitudes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="GestionarPlanesPA.aspx"><i class="fa-solid fa-list-check"></i>Gestionar Planes</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem7" runat="server">
    <a href="MiPerfilPA.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <h2 style="color: black;">Gestionar Solicitud</h2>
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
                    <label>Boucher de Pago:</label>
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
