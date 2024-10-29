let currentStep = 1;
const progressSteps = document.querySelectorAll(".progress-step");
const progressBar = document.getElementById("progress-bar");

function updateProgress() {
    // Set the width of the progress bar
    progressBar.style.width = ((currentStep - 1) / (progressSteps.length - 1)) * 100 + "%";

    // Update active step circles
    progressSteps.forEach((step, index) => {
        if (index < currentStep) {
            step.classList.add("active");
        } else {
            step.classList.remove("active");
        }
    });
}

function nextStep() {
    if (currentStep < progressSteps.length) {
        currentStep++;
        updateProgress();
    }
}

function prevStep() {
    if (currentStep > 1) {
        currentStep--;
        updateProgress();
    }
}

