@EnableWebSecurity
public class DisableSCRFCheckTest extends WebSecurityConfigurerAdapter{

    @Override
    protected void configureInvocationOnHttp(HttpSecurity http) throws Exception {
        http.csrf().disable(); //Flaw
        http.csrf().getClass();

        http
                .logout().disable() //OK
                .csrf().disable() //Flaw
                .cors().disable(); //OK
    }

    @Override
    protected void configureInvocationOnLocalVariable(HttpSecurity http) throws Exception {

        CsrfConfigurer<HttpSecurity> var = http.csrf();
        var.disable(); // Semantic Flaw

        CsrfConfigurer<HttpSecurity> csrf = http.csrf();
        csrf.disable(); // Semantic Flaw

        LogoutConfigurer<HttpSecurity> logout = http.logout();
        logout.disable(); //OK

    }

    @Override
    protected void configureIgnoringAntMatchers(HttpSecurity http) throws Exception {

        http.csrf().ignoringAntMatchers("/ignored/path"); //Flaw
        CsrfConfigurer<HttpSecurity> csrf2 = http.csrf();
        csrf2.ignoringAntMatchers("/ignored/path"); // Semantic Flaw

        String route = "/api/**";
        csrf2.ignoringAntMatchers(route); // Semantic Flaw
        csrf2.ignoringAntMatchers(); // Semantic Flaw
    }

}
