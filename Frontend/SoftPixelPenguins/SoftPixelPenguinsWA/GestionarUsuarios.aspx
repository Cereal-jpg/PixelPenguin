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
                <h2>Lista de Usuarios</h2>
                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addUserModal">
                    <i class="fa-solid fa-user-plus"></i> Agregar Nuevo Usuario
                </button>
            </div>

            <div class="col-12">
                <asp:GridView ID="gvUsuarios" runat="server" AutoGenerateColumns="False" OnRowCommand="gvUsuarios_RowCommand">
                    <Columns>
                        <asp:BoundField HeaderText="Email" DataField="email" />
                         <asp:BoundField HeaderText="Usuario" DataField="username" />
                        <asp:BoundField HeaderText="Nombre Completo" DataField="nombreCompleto" />
                        <asp:BoundField HeaderText="Rol" DataField="rol.nombre" />
                        <asp:TemplateField HeaderText="Acciones">
                            <ItemTemplate>
                                <asp:Button ID="btnEdit" runat="server" CommandName="Edit" CommandArgument='<%# Eval("idUsuario") %>' Text="Editar" CssClass="btn btn-warning btn-sm" />
                                <asp:Button ID="btnDelete" runat="server" CommandName="Delete" CommandArgument='<%# Eval("idUsuario") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" />
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
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
                        <label for="ddlRoles" class="form-label">Rol</label>
                        <select id="ddlRoles" class="form-select" onchange="toggleRoleFields()">
                            <option value="">Seleccione un rol</option>
                            <option value="Alumno">Alumno</option>
                            <option value="Profesor">Profesor</option>
                            <option value="PersonalAdministrativo">Personal Administrativo</option>
                        </select>
                    </div>

                    <!-- Campos específicos para Alumno -->
                    <div id="alumnoFields" class="role-specific-fields" style="display: none;">
                        <div class="mb-3">
                            <label for="codigoAlumno" class="form-label">Código Alumno</label>
                            <input type="number" class="form-control" id="codigoAlumno" placeholder="Ingrese el código del alumno" />
                        </div>
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" id="conCertificadoDeEstudios" />
                            <label class="form-check-label" for="conCertificadoDeEstudios">Con Certificado de Estudios</label>
                        </div>
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" id="conCertificadoDeSalud" />
                            <label class="form-check-label" for="conCertificadoDeSalud">Con Certificado de Salud</label>
                        </div>
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" id="conDeuda" />
                            <label class="form-check-label" for="conDeuda">Con Deuda</label>
                        </div>
                        <div class="mb-3">
                            <label for="apoderado" class="form-label">Apoderado (ID)</label>
                            <input type="number" class="form-control" id="apoderado" placeholder="Ingrese el ID del apoderado" />
                        </div>
                        <div class="mb-3">
                            <label for="gradoAcademico" class="form-label">Grado Académico (ID)</label>
                            <input type="number" class="form-control" id="gradoAcademico" placeholder="Ingrese el ID del grado académico" />
                        </div>
                    </div>

                    <!-- Campos específicos para Profesor -->
                    <div id="profesorFields" class="role-specific-fields" style="display: none;">
                        <div class="mb-3">
                            <label for="codigoProfesor" class="form-label">Código Profesor</label>
                            <input type="number" class="form-control" id="codigoProfesor" placeholder="Ingrese el código del profesor" />
                        </div>
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" id="certificadoHistorialEducativo" />
                            <label class="form-check-label" for="certificadoHistorialEducativo">Con Certificado de Historial Educativo</label>
                        </div>
                        <div class="mb-3">
                            <label for="especialidad" class="form-label">Especialidad</label>
                            <input type="text" class="form-control" id="especialidad" placeholder="Ingrese la especialidad" />
                        </div>
                    </div>

                    <!-- Campos específicos para Personal Administrativo -->
                    <div id="personalFields" class="role-specific-fields" style="display: none;">
                        <div class="mb-3">
                            <label for="codigoPersonalAdministrativo" class="form-label">Código Personal Administrativo</label>
                            <input type="number" class="form-control" id="codigoPersonalAdministrativo" placeholder="Ingrese el código del personal administrativo" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-primary" form="userForm">Guardar</button>
            </div>
        </div>
    </div>
</div>

<script>
    function toggleRoleFields() {
        const role = document.getElementById("ddlRoles").value;
        const alumnoFields = document.getElementById("alumnoFields");
        const profesorFields = document.getElementById("profesorFields");
        const personalFields = document.getElementById("personalFields");

        alumnoFields.style.display = role === "Alumno" ? "block" : "none";
        profesorFields.style.display = role === "Profesor" ? "block" : "none";
        personalFields.style.display = role === "PersonalAdministrativo" ? "block" : "none";
    }
</script>


</asp:Content>

