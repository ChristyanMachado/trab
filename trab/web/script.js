function login() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
  
    // Aqui você faria a requisição para a API em Java usando AJAX ou Fetch API
  
    // Exemplo usando Fetch API
    fetch(`http://sua-api.com/login?email=${email}&password=${password}`)
      .then(response => response.json())
      .then(data => {
        if (data.success) {
          document.getElementById('message').innerText = 'Cliente logado com sucesso!';
        } else {
          document.getElementById('message').innerText = 'Login falhou. Verifique suas credenciais.';
        }
      })
      .catch(error => {
        console.error('Erro ao realizar o login:', error);
      });
  }
  