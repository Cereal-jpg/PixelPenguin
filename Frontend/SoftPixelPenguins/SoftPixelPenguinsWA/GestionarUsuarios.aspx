<%@ Page Title="Gestión de Usuarios" Language="C#" MasterPageFile="~/SoftPixelPenguins.Master" AutoEventWireup="true" CodeBehind="GestionarUsuarios.aspx.cs" Inherits="SoftPixelPenguinsWA.GestionarUsuarios" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión de Usuarios
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem1" runat="server">
    <a href="Index.aspx"><i class="fa-solid fa-home"></i>Pagina principal</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem2" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-database"></i>Consultas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem3" runat="server">
    <a href="ListarCursosAlumno.aspx"><i class="fa-solid fa-search"></i>Busquedas</a>
</asp:Content>
<asp:Content ContentPlaceHolderID="menuItem4" runat="server">
    <a href="GestionarUsuarios.aspx"><i class="fa-solid fa-plus-circle"></i>Gestionar Usuario</a>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container mt-5">
        <div class="row">
            <div class="col-12 d-flex justify-content-between align-items-center mb-4">
                <h2>Gestionar Usuarios</h2>
                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addUserModal">
                    <i class="fa-solid fa-user-plus"></i> Agregar Nuevo Usuario
                </button>
            </div>
            <div class="row">
                <div class="col-12">
                    <asp:GridView ID="gvUsuarios" runat="server" AutoGenerateColumns="False" OnRowCommand="gvUsuarios_RowCommand" CssClass="table table-striped table-bordered" Style="background-color: transparent;">
                        <Columns>
                            <asp:BoundField HeaderText="Email" DataField="email" />
                            <asp:BoundField HeaderText="Usuario" DataField="username" />
                            <asp:BoundField HeaderText="Nombre Completo" DataField="nombreCompleto" />
                            <asp:BoundField HeaderText="Rol" DataField="rol.nombre" />
                            <asp:TemplateField HeaderText="Acciones">
                                <ItemTemplate>
                                    <asp:Button ID="btnEdit" runat="server" CommandName="Edit" CommandArgument='<%# Eval("idUsuario") %>' Text="Editar" CssClass="btn btn-warning btn-sm me-1" />
                                    <asp:Button ID="btnDelete" runat="server" CommandName="Delete" CommandArgument='<%# Eval("idUsuario") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" />
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Agregar/Editar Usuario -->
<div class="modal fade" id="addUserModal" tabindex="-1" aria-labelledby="addUserModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addUserModalLabel">Agregar Usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="userForm">
                    <div class="mb-3">
                        <label for="nombreCompleto" class="form-label">Nombre Completo</label>
                        <input type="text" class="form-control" id="nombreCompleto" placeholder="Ingrese el nombre completo" required />
                    </div>
                    <div class="mb-3">
                        <label for="dni" class="form-label">DNI</label>
                        <input type="text" class="form-control" id="dni" placeholder="Ingrese el DNI" required />
                    </div>
                    <div class="mb-3">
                        <label for="fechaNacimiento" class="form-label">Fecha de Nacimiento</label>
                        <input type="date" class="form-control" id="fechaNacimiento" required />
                    </div>
                    <div class="mb-3">
                        <label for="direccion" class="form-label">Dirección</label>
                        <input type="text" class="form-control" id="direccion" placeholder="Ingrese la dirección" required />
                    </div>
                    <div class="mb-3">
                        <label for="userEmail" class="form-label">Email</label>
                        <input type="email" class="form-control" id="userEmail" placeholder="Ingrese el email" required />
                    </div>
                    <div class="mb-3">
                        <label for="sexo" class="form-label">Sexo</label>
                        <select id="sexo" class="form-select" required>
                            <option value="">Seleccione el sexo</option>
                            <option value="Masculino">Masculino</option>
                            <option value="Femenino">Femenino</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="username" class="form-label">Nombre de Usuario</label>
                        <input type="text" class="form-control" id="username" placeholder="Ingrese el nombre de usuario" required />
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="password" placeholder="Ingrese la contraseña" required />
                    </div>
                    <div class="mb-3">
                        <label for="ddlRoles" class="form-label">Seleccione un rol</label>
                        <div class="input-group">
                            <asp:DropDownList ID="ddlRoles" runat="server" AutoPostBack="false" OnChange="mostrarCampos()" CssClass="form-select">
                            </asp:DropDownList>
                        </div>
                    </div>

                    <!-- Campos específicos para Alumno -->
                    <div id="alumnoFields" class="mb-3" style="display: none;">
                        <div class="mb-3">
                            <label for="codigoAlumno" class="form-label">Código Alumno</label>
                            <asp:TextBox ID="codigoAlumno" runat="server" CssClass="form-control" placeholder="Ingrese el código del alumno"></asp:TextBox>
                        </div>
                        <div class="form-check mb-3">
                            <asp:CheckBox ID="conCertificadoDeEstudios" runat="server" CssClass="form-check-input" />
                            <label class="form-check-label" for="conCertificadoDeEstudios">Con Certificado de Estudios</label>
                        </div>
                        <div class="form-check mb-3">
                            <asp:CheckBox ID="conCertificadoDeSalud" runat="server" CssClass="form-check-input" />
                            <label class="form-check-label" for="conCertificadoDeSalud">Con Certificado de Salud</label>
                        </div>
                        <div class="form-check mb-3">
                            <asp:CheckBox ID="conDeuda" runat="server" CssClass="form-check-input" />
                            <label class="form-check-label" for="conDeuda">Con Deuda</label>
                        </div>
                        <div class="mb-3">
                            <label for="apoderado" class="form-label">Apoderado (ID)</label>
                            <asp:TextBox ID="apoderado" runat="server" CssClass="form-control" placeholder="Ingrese el ID del apoderado"></asp:TextBox>
                        </div>
                        <div class="mb-3">
                            <label for="gradoAcademico" class="form-label">Grado Académico (ID)</label>
                            <asp:TextBox ID="gradoAcademico" runat="server" CssClass="form-control" placeholder="Ingrese el ID del grado académico"></asp:TextBox>
                        </div>
                    </div>

                    <!-- Campos específicos para Profesor -->
                    <div id="profesorFields" class="mb-3" style="display: none;">
                        <div class="mb-3">
                            <label for="codigoProfesor" class="form-label">Código Profesor</label>
                            <asp:TextBox ID="codigoProfesor" runat="server" CssClass="form-control" placeholder="Ingrese el código del profesor"></asp:TextBox>
                        </div>
                        <div class="form-check mb-3">
                            <asp:CheckBox ID="certificadoHistorialEducativo" runat="server" CssClass="form-check-input" />
                            <label class="form-check-label" for="certificadoHistorialEducativo">Con Certificado de Historial Educativo</label>
                        </div>
                        <div class="mb-3">
                            <label for="especialidad" class="form-label">Especialidad</label>
                            <asp:TextBox ID="especialidad" runat="server" CssClass="form-control" placeholder="Ingrese la especialidad"></asp:TextBox>
                        </div>
                    </div>

                    <!-- Campos específicos para Personal Administrativo -->
                    <div id="personalFields" class="mb-3" style="display: none;">
                        <div class="mb-3">
                            <label for="codigoPersonalAdministrativo" class="form-label">Código Personal Administrativo</label>
                            <asp:TextBox ID="codigoPersonalAdministrativo" runat="server" CssClass="form-control" placeholder="Ingrese el código del personal administrativo"></asp:TextBox>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-primary" form="userForm" OnClick="btn_Guardar">Guardar</button>
            </div>
        </div>
    </div>
</div>

    <script type="text/javascript">
        function mostrarCampos() {
            var rolSeleccionado = document.getElementById('<%= ddlRoles.ClientID %>').value;
            // Ocultar todos los campos
            document.getElementById('alumnoFields').style.display = 'none';
            document.getElementById('profesorFields').style.display = 'none';
            document.getElementById('personalFields').style.display = 'none';

            // Mostrar campos basados en el rol seleccionado
            if (rolSeleccionado === "1") { // Alumno
                document.getElementById('alumnoFields').style.display = 'block';
            } else if (rolSeleccionado === "2") { // Profesor
                document.getElementById('profesorFields').style.display = 'block';
            } else if (rolSeleccionado === "3") { // Personal Administrativo
                document.getElementById('personalFields').style.display = 'block';
            }
        }
    </script>

</asp:Content>

