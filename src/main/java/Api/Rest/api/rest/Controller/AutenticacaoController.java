package Api.Rest.api.rest.Controller;

import Api.Rest.api.rest.domain.Usuario.DadosAuteticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAuteticacao dados){
        var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.senha());
        var autenticacao = manager.authenticate(token);
        return ResponseEntity.ok().build();
    }

}
