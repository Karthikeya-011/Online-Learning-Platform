<script>
    window.onload = function() {
        const userId = localStorage.getItem("loggedInUser");
        if (!userId) return;
    
        fetch(`http://localhost:8080/api/recommendations?userId=${userId}`)
        .then(res => res.json())
        .then(data => {
            let output = "";
    
            for (const strategy in data) {
                output += `<h4>${strategy.toUpperCase()}:</h4><ul>`;
                data[strategy].forEach(course => {
                    output += `<li>${course}</li>`;
                });
                output += "</ul>";
            }
    
            document.getElementById("recommendations").innerHTML = output;
        });
    }
    </script>
    
    <div id="recommendations" class="container mt-4"></div>
    