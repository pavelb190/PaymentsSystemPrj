<%@ page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="?command=logout">Exit(x)</a>
<h2>${viewModel.user.firstName}&nbsp;${viewModel.user.lastName}</h2>
<h2>${viewModel.user}</h2>
<h2>${viewModel.aaa}</h2>
<h3>From Session: ${sessionScope.user}</h3>
</body>
</html>
