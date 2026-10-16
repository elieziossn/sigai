package ifrn.sigai.servicoimoveis.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import ifrn.sigai.servicoimoveis.model.Usuario;
import ifrn.sigai.servicoimoveis.repository.UsuarioRepository;

@Component 
public class DataSeeder implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() > 0) {
            return; // se já tem usuário, não duplica
        }

        Usuario admin = new Usuario();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole("ADMIN");
        usuarioRepository.save(admin);

        Usuario corretor = new Usuario();
        corretor.setUsername("corretor");
        corretor.setPassword(passwordEncoder.encode("corretor123"));
        corretor.setRole("CORRETOR");
        usuarioRepository.save(corretor);

        System.out.println(">>> Usuários de teste criados: admin/admin123, corretor/corretor123");
    }
}