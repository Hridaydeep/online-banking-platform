document.getElementById('userForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const accountHolderName = document.getElementById('accountHolderName').value;
    const balance = parseFloat(document.getElementById('balance').value).toFixed(2);
    const phoneNumber = document.getElementById('phoneNumber').value;
    const dob = document.getElementById('dob').value;

    const data = {
        accountHolderName: accountHolderName,
        balance: balance,
        phoneNumber: phoneNumber,
        dob: dob
    };

    fetch("http://192.168.29.157:8080/REST-API/accounts/newUser", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(result => {
        // Redirect to Success.html with query parameters
        const id = result.id; // Adjust this based on your actual response structure
        const name = result.accountHolderName; // Adjust this based on your actual response structure
        window.location.href = `Success.html?id=${id}&name=${encodeURIComponent(name)}`;
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Error occurred: ' + error.message);
    });
});
