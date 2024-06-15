<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Change Login</title>
</head>
<body>
<form action="change-login" method="post">
  <h4>${message}</h4>
  <div>
    <label for="id"><h3>Enter id:</h3></label>
    <input name="id" type="number" id="id" value="" />
  </div>
  <div>
    <label for="login"><h3>Enter new login:</h3></label>
    <input name="login" type="text" id="login" value="" />
  </div>
  <div>
    <button>Send</button>
  </div>
</form>
</body>
</html>