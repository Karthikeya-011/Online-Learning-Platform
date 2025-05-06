<!-- login.html -->
<script>
    document.getElementById('loginForm').addEventListener('submit', function(event) {
        event.preventDefault();
        
        const userId = document.getElementById('userId').value;
        const password = document.getElementById('password').value;

        if (userId && password) {
            // Assuming you have an API endpoint for login like '/api/login'
            fetch('/api/login', {
                method: 'POST',
                body: JSON.stringify({ userId, password }),
                headers: {
                    'Content-Type': 'application/json',
                },
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert('Login successful!');
                    window.location.href = 'courses.html'; // Redirect to the courses page after successful login
                } else {
                    alert('Invalid credentials, please try again.');
                }
            })
            .catch(error => console.error('Error logging in:', error));
        } else {
            alert('Please enter both User ID and Password');
        }
    });
</script>
