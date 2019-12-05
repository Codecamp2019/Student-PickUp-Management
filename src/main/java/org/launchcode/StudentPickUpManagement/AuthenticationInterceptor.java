//package org.launchcode.StudentPickUpManagement;
//        import org.launchcode.StudentPickUpManagement.controllers.AbstractController;
//        import org.launchcode.StudentPickUpManagement.controllers.AbstractController;
//        import org.launchcode.StudentPickUpManagement.models.Entity.User;
//        import org.launchcode.StudentPickUpManagement.models.data.UserDao;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//        import javax.servlet.http.HttpServletRequest;
//        import javax.servlet.http.HttpServletResponse;
//        import java.io.IOException;
//        import java.util.Arrays;
//        import java.util.List;
//
///**
// * Created by LaunchCode
// */
//public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
//
//    @Autowired
//    UserDao userDao;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
//
//        List<String> nonAuthPages = Arrays.asList("/user");
//
//        // Require sign-in for auth pages
//        if ( !nonAuthPages.contains(request.getRequestURI()) ) {
//
//            boolean isLoggedIn = false;
//            User user;
//            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);
//
//            if (userId != null) {
//                user = userDao.findById(userId).get();
//
//                if (user != null)
//                    isLoggedIn = true;
//            }
//
//            // If user not logged in, redirect to login page
//            if (!isLoggedIn) {
//                response.sendRedirect("/user");
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//}
