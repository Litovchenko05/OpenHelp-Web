console.log("Enter to GetRequest");
document.addEventListener("DOMContentLoaded", function() {

    const usersTable = document.getElementById("users");
    const users = [];

    function loadUsersList() {
        console.log("Enter to loadUsersList");
        fetch("/OpenHelp-Web/users?action=getAll")
            .then(response => response.json())
            .then(data => {
                console.log("data : "+data);
                data.forEach(user =>{
                    users.push(user);
                    usersTable.innerHTML += `
            <tr>
              <td>${user.username}</td>
              <td>${user.password}</td>
              <td>${user.email}</td>
              <td>${user.name}</td>
            </tr>
          `
                });
            });
    }
    loadUsersList();
});