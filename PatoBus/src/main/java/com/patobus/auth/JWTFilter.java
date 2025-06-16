// package com.patobus.auth;

// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.patobus.service.UsuarioService;

// @Component
// public class JWTFilter extends OncePerRequestFilter {

//     @Autowired
//     private jwtService jwtService;

//     @Autowired
//     private UsuarioService usuarioService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//         throws ServletException, IOException {

//         String authHeader = request.getHeader("Authorization");
//         if (authHeader != null && authHeader.startsWith("Bearer ")) {
//             String token = authHeader.substring(7);
//             String email = jwtService.extractUsername(token);

//             if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                 Optional<Usuario> usuarioOpt = usuarioService.findByEmail(email);
//                 if (usuarioOpt.isPresent() && jwtService.isTokenValid(token, usuarioOpt.get())) {
//                     UserDetails userDetails = new UsuarioUserDetails(usuarioOpt.get());
//                     UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                         userDetails, null, userDetails.getAuthorities());
//                     authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                     SecurityContextHolder.getContext().setAuthentication(authToken);
//                 }
//             }
//         }
//         filterChain.doFilter(request, response);
//     }
// }
