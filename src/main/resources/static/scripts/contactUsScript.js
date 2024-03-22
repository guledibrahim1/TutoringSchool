document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent form from submitting normally

        let isValid = true;
        const formData = {
            name: document.getElementById('name').value.trim(),
            email: document.getElementById('email').value.trim(),
            subject: document.getElementById('subject').value.trim(),
            message: document.getElementById('message').value.trim(),
        };

        // Simple validation
        Object.keys(formData).forEach(function(key) {
            if (formData[key] === '') {
                alert(`Please fill out the ${key} field.`);
                isValid = false;
                return; // Break the forEach loop on first validation failure
            }
        });

        // Additional email validation
        if (isValid && !formData.email.includes('@')) {
            alert('Please enter a valid email address.');
            isValid = false;
        }

        // If valid, show success message and reset form
        if (isValid) {
            alert('Thank you for contacting us! Your message has been successfully sent.');
            form.reset();
        }
    });
});
