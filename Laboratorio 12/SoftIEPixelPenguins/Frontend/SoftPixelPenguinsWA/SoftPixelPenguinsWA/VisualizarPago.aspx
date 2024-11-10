<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="VisualizarPago.aspx.cs" Inherits="SoftPixelPenguinsWA.VisualizarPago" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Visualizar - Pago
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
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
    <a href="IndexAlumno.aspx"><i class="fa-solid fa-home"></i>Inicio</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="MisCursosAlumno.aspx"><i class="fa-solid fa-book"></i>Mis cursos</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ReporteNotasAlumno.aspx"><i class="fa-solid fa-bar-chart"></i>Reporte de Notas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="MatriculaOnlineAlumno.aspx"><i class="fa-solid fa-archive"></i>Matrícula Online</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem5" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-user"></i>Mi Perfil</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem6" runat="server">
    <a href="MiPerfilAlumno.aspx"><i class="fa-solid fa-book"></i>Mis Pagos</a>
</asp:Content>


<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="d-flex justify-content-between align-items-center mt-3 mx-3">
        <h1>Visualizar datos del Pago</h1>
    </div>
    <hr class="mx-3" />
    <div class="container">
        <div class="main-content">
            <h3>Datos del pago</h3>
            <div class="form-group">
                <div class="form-row">
                    <label>Fecha Creacion:</label>
                    <asp:TextBox ID="txtFechaCreacion" runat="server" placeholder="Fecha de creacion"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label>Fecha Pago:</label>
                    <asp:TextBox ID="txtFechaPago" runat="server" placeholder="Fecha de cancelacion"></asp:TextBox>
                </div>
            </div>
            <div class="form-group">
                <div class="form-row">
                    <label>Tipo de comprobante:</label>
                    <asp:TextBox ID="txtTipoComprobante" runat="server" placeholder="Tipo de comprobante"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label>Estado del pago:</label>
                    <asp:TextBox ID="txtEstadoPago" runat="server" placeholder="Estado del pago"></asp:TextBox>
                </div>
                <div class="form-row">
                    <label>Tipo de pago:</label>
                    <asp:TextBox ID="txtTipodePago" runat="server" placeholder="Tipo de pago"></asp:TextBox>
                </div>
            </div>
            <div class="form-section">
                <h3>Ver comprobante de pago</h3>
                <div class="form-row">
                    <label>Comprobante del pago:</label>
                    <asp:LinkButton ID="lnkDescargarComprobante" runat="server" CssClass="btn btn-info me-2" OnClick="lnkDescargarComprobante_Click">
                       Descargar Comprobante del pago
                    </asp:LinkButton>
                </div>
        </div>
    </div>
</asp:Content>





