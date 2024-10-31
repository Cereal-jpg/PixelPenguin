let currentStep = 1;
const progressSteps = document.querySelectorAll(".progress-step");
const progressBar = document.getElementById("progress-bar");
let uploadedBoucher = null;


function nextStep2() {
    const container = document.getElementById('container-proceso');
    const inputs = document.querySelectorAll('input'); // Selecciona todos los inputs

    // Recorre todos los inputs y guarda sus valores
    inputs.forEach(input => {
        formData[input.name] = input.value; // Almacena el valor en formData
    });

    // Verifica si todos los inputs están llenos
    let allFilled = true; // Variable para validar si todos los inputs están llenos
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
        const container = document.getElementById('container-proceso');
        // Cambia el contenido del contenedor al siguiente paso
        container.innerHTML = `
            <div class="matricula-section" style="padding: 5px;">
                <h3 style="border-bottom: 2px solid #ccc; width:100%">
                    Proceso de matrícula - Certificados
                </h3>
                <div class="progress-wrapper">
                    <div class="progress-container">
                        <div class="progress-bar" id="progress-bar"></div>
                        <div class="progress-step active">1</div>
                        <div class="progress-step active">2</div>
                        <div class="progress-step">3</div>
                        <div class="progress-step">4</div>
                    </div>
                </div>
                <p>
                    Valida y, si es necesario, actualiza los certificados correspondientes de ALFREDO ERNESTO SANCHEZ TUESTA.
                </p>

                <div class="datos-container">
                    <h4 style="font-size: 17px; border-bottom: 2px solid #808080; width:100%;">
                        Adjuntar Certificados
                    </h4>

                    <!-- Certificado de Estudios -->
                    <div class="form-row">
                        <div class="file-input-group">
                            <label for="certificado-estudios" style="width:100%; display:block;">
                                Adjuntar Certificado de Estudios:
                            </label>
                            <input type="file" id="certificado-estudios" name="certificado-estudios" 
                                style="background-color: white; border-radius: 5px; width: 100%; box-sizing: border-box;" />
                        </div>
                    </div>

                    <!-- Certificado de Salud -->
                    <div class="form-row">
                        <div class="file-input-group">
                            <label for="certificado-salud">Adjuntar Certificado de Salud:</label>
                            <input style="background-color:white; border-radius:5px; width:100%;" 
                                type="file" id="certificado-salud" name="certificado-salud" />
                        </div>
                    </div>
                </div>

                <div class="buttons">
                    <button onclick="prevStep2()">Atrás</button>
                    <button>Guardar</button>
                    <button>Editar</button>
                    <button onclick="nextStep3()">Grabar y Continuar</button>
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
            <h3 style="border-bottom: 2px solid #ccc; width:100%">
                Proceso de matrícula - Boucher de Pago
            </h3>
            <div class="progress-wrapper">
                <div class="progress-container">
                    <div class="progress-bar" id="progress-bar"></div>
                    <div class="progress-step active">1</div>
                    <div class="progress-step active">2</div>
                    <div class="progress-step active">3</div>
                    <div class="progress-step">4</div>
                </div>
            </div>
            <p>
                Realice el pago correspondiente de la matrícula para continuar con el proceso de matrícula.
            </p>

            <div class="datos-container">
                <h4 style="font-size: 17px; border-bottom: 2px solid #808080; width:100%;">
                    Adjuntar Boucher del pago
                </h4>
                <p style="width: 100%; margin: 0;">
                    Debe realizar el pago correspondiente de la matrícula para continuar con el proceso de matrícula.
                </p>
                <div class="container-Boucher" style="background-color: #f0f0f0; padding: 10px; border-radius: 5px; margin: 10px auto; width: 300px; text-align: center;">
                    <p>Cuenta Bancaria a depositar:</p>
                    <p>XXXX-XXXX-XXXXXXXXXX</p>
                </div>
                <!-- Boucher de Pago -->
                <div class="form-row">
                    <div class="file-input-group">
                        <label for="boucher-pago">Adjuntar Boucher de Pago:</label>
                        <input style="background-color:white; border-radius:5px; width:100%;" type="file" id="boucher-pago" name="boucher-pago" onchange="handleFileUpload(event)" />
                    </div>
                </div>
                <div id="uploaded-file-name" style="margin-top: 10px;"></div>
            </div>

            <div class="buttons">
                <button onclick="prevStep3()">Atrás</button>
                <button>Guardar</button>
                <button>Editar</button>
                <button onclick="nextStep4()">Grabar y Continuar</button>
            </div>
        </div>
    `;

    // Mostrar el nombre del archivo si ya se ha cargado
    const fileNameContainer = document.getElementById('uploaded-file-name');
    if (uploadedBoucher) {
        fileNameContainer.innerHTML = `Archivo cargado: ${uploadedBoucher.name}`;
    } else {
        fileNameContainer.innerHTML = '';
    }
}

function handleFileUpload(event) {
    uploadedBoucher = event.target.files[0]; // Guardar el archivo en la variable
}

function prevStep2() {
    const container = document.getElementById('container-proceso');

    // Cambia el contenido del contenedor al paso anterior
    container.innerHTML = `
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
                            <input type="text" id="nombre" name="nombre" value="${formData.nombre}" required />
                        </div>
                        <div class="form-group">
                            <label for="apellido-paterno">Apellido Paterno:</label>
                            <input type="text" id="apellido-paterno" name="apellido-paterno" value="${formData.apellidoPaterno}" required />
                        </div>
                        <div class="form-group">
                            <label for="apellido-materno">Apellido Materno:</label>
                            <input type="text" id="apellido-materno" name="apellido-materno" value="${formData.apellidoMaterno}" required />
                        </div>
                    </div>

                    <!-- Fila con cuatro campos alineados horizontalmente -->
                    <div class="form-row">
                        <div class="form-group">
                            <label for="dni">DNI:</label>
                            <input type="text" id="dni" name="dni" value="${formData.dni}" required />
                        </div>
                        <div class="form-group">
                            <label for="fecha-nacimiento">Fecha de Nacimiento:</label>
                            <input type="date" id="fecha-nacimiento" name="fecha-nacimiento" value="${formData.fechaNacimiento}" required />
                        </div>
                        <div class="form-group">
                            <label for="sexo">Sexo:</label>
                            <input type="text" id="sexo" name="sexo" value="${formData.sexo}" required />
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email" value="${formData.email}" required />
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
    `;
}

function prevStep3() {
    // Cambia el contenido del contenedor al siguiente paso
    const container = document.getElementById('container-proceso');
    // Cambia el contenido del contenedor al siguiente paso
    container.innerHTML = `
            <div class="matricula-section" style="padding: 5px;">
                <h3 style="border-bottom: 2px solid #ccc; width:100%">
                    Proceso de matrícula - Certificados
                </h3>
                <div class="progress-wrapper">
                    <div class="progress-container">
                        <div class="progress-bar" id="progress-bar"></div>
                        <div class="progress-step active">1</div>
                        <div class="progress-step active">2</div>
                        <div class="progress-step">3</div>
                        <div class="progress-step">4</div>
                    </div>
                </div>
                <p>
                    Valida y, si es necesario, actualiza los certificados correspondientes de ALFREDO ERNESTO SANCHEZ TUESTA.
                </p>

                <div class="datos-container">
                    <h4 style="font-size: 17px; border-bottom: 2px solid #808080; width:100%;">
                        Adjuntar Certificados
                    </h4>

                    <!-- Certificado de Estudios -->
                    <div class="form-row">
                        <div class="file-input-group">
                            <label for="certificado-estudios" style="width:100%; display:block;">
                                Adjuntar Certificado de Estudios:
                            </label>
                            <input type="file" id="certificado-estudios" name="certificado-estudios" 
                                style="background-color: white; border-radius: 5px; width: 100%; box-sizing: border-box;" />
                        </div>
                    </div>

                    <!-- Certificado de Salud -->
                    <div class="form-row">
                        <div class="file-input-group">
                            <label for="certificado-salud">Adjuntar Certificado de Salud:</label>
                            <input style="background-color:white; border-radius:5px; width:100%;" 
                                type="file" id="certificado-salud" name="certificado-salud" />
                        </div>
                    </div>
                </div>

                <div class="buttons">
                    <button onclick="prevStep2()">Atrás</button>
                    <button>Guardar</button>
                    <button>Editar</button>
                    <button onclick="nextStep3()">Grabar y Continuar</button>
                </div>
            </div>
        `;
}