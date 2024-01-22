<!DOCTYPE html>
<html>
<body>

<form id="loginForm">
  <div>
    <label for="username">Benutzername:</label>
    <input type="text" id="username" name="username">
  </div>
  <div>
    <label for="password">Passwort:</label>
    <input type="password" id="password" name="password">
  </div>
  <div>
    <input type="submit" value="Submit">
  </div>
</form>

<script>
  document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); 

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    console.log('Benutzername:', username, 'Passwort:', password);
    
  });
</script>

</body>
</html>
