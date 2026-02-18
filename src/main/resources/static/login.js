function login() {
    fetch("/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: document.getElementById("email").value,
            password: document.getElementById("password").value
        })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Login failed");
        }
        return response.json();
    })
    .then(data => {
        // ÖNEMLİ KISIM
        localStorage.setItem("authHeader", "Bearer " + data.token);

        // Ana sayfaya yönlendir
        window.location.href = "index.html";
    })
    .catch(error => {
        document.getElementById("loginResult").innerText =
            "Invalid email or password";
    });
}