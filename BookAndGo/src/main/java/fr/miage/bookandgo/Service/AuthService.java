@Service
public class AuthService {

    private final UserRepository userRepository;
    private final AgentRepository agentRepository;
    private final AgentProfessionnelRepository agentProRepository;
    private final LoueurRepository loueurRepository;
    private final PasswordEncoder passwordEncoder; // injecté

    public AuthService(UserRepository userRepository,
                       AgentRepository agentRepository,
                       AgentProfessionnelRepository agentProRepository,
                       LoueurRepository loueurRepository,
                       PasswordEncoder passwordEncoder) { // injecté ici
        this.userRepository = userRepository;
        this.agentRepository = agentRepository;
        this.agentProRepository = agentProRepository;
        this.loueurRepository = loueurRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Inscription
    public User inscription(InscriptionDTO dto) throws Exception {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new Exception("Email déjà utilisé");
        }

        User user = new User();
        user.setNom(dto.getNom());
        user.setPrenom(dto.getPrenom());
        user.setEmail(dto.getEmail());
        user.setMdp(passwordEncoder.encode(dto.getPassword())); // hash
        user.setRole(dto.getRole());
        userRepository.save(user);

        // Création des rôles
        if (dto.getRole() == Role.AGENT) {
            Agent agent = new Agent();
            agent.setUser(user);
            agent.setTypeAgent(TypeAgent.PARTICULIER);
            agent.setSiret(null);
            agent.setRib(dto.getRib());
            agentRepository.save(agent);

        } else if (dto.getRole() == Role.AGENT_PRO) {
            Agent agent = new Agent();
            agent.setUser(user);
            agent.setTypeAgent(TypeAgent.PRO);

            if (dto.getSiret() == null || dto.getSiret().isEmpty()) {
                throw new Exception("SIRET obligatoire pour agent pro");
            }
            agent.setSiret(dto.getSiret());
            agent.setRib(dto.getRib());
            agentRepository.save(agent);

            AgentProfessionnel pro = new AgentProfessionnel();
            pro.setAgent(agent);
            pro.setNomPro(dto.getNomPro());
            agentProRepository.save(pro);

        } else if (dto.getRole() == Role.LOUEUR) {
            Loueur loueur = new Loueur();
            loueur.setUser(user);
            loueurRepository.save(loueur);
        }

        return user;
    }

    // Connexion
    public User connexion(ConnexionDTO dto) throws Exception {
        User user = userRepository.findByEmail(dto.getEmail());
        if (user == null) throw new Exception("Email non trouvé");

        if (!passwordEncoder.matches(dto.getPassword(), user.getMdp()))
            throw new Exception("Mot de passe incorrect");

        return user;
    }
}
