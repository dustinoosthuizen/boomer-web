// @SOURCE:/home/dustin/Dev/boomer/conf/routes
// @HASH:57ae00f0992b471f425539a1ab3d3a21b97b5393
// @DATE:Sun Aug 17 20:26:01 SAST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseUserController {
    

// @LINE:11
def getUserByEmail(email:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/user/getByEmail/" + implicitly[PathBindable[String]].unbind("email", dynamicString(email)))
}
                                                

// @LINE:12
def getUsers(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/user/query")
}
                                                

// @LINE:13
def saveUser(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/user/save")
}
                                                

// @LINE:9
def getUser(id:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/user/get/" + implicitly[PathBindable[Integer]].unbind("id", id))
}
                                                

// @LINE:10
def getUserByToken(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/user/getByToken")
}
                                                
    
}
                          

// @LINE:20
class ReverseLoginController {
    

// @LINE:20
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/login/login")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:24
// @LINE:23
class ReverseItemController {
    

// @LINE:24
def page(page:Integer, pageSize:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/item/page/" + implicitly[PathBindable[Integer]].unbind("page", page) + "/" + implicitly[PathBindable[Integer]].unbind("pageSize", pageSize))
}
                                                

// @LINE:23
def addItem(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/item/add")
}
                                                
    
}
                          

// @LINE:17
// @LINE:16
class ReverseRegistrationController {
    

// @LINE:17
def confirmation(id:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "api/registration/confirmation/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                                                

// @LINE:16
def register(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "api/registration/register")
}
                                                
    
}
                          
}
                  


// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseUserController {
    

// @LINE:11
def getUserByEmail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.getUserByEmail",
   """
      function(email) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/getByEmail/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("email", encodeURIComponent(email))})
      }
   """
)
                        

// @LINE:12
def getUsers : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.getUsers",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/query"})
      }
   """
)
                        

// @LINE:13
def saveUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.saveUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/save"})
      }
   """
)
                        

// @LINE:9
def getUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.getUser",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/get/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:10
def getUserByToken : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.UserController.getUserByToken",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/getByToken"})
      }
   """
)
                        
    
}
              

// @LINE:20
class ReverseLoginController {
    

// @LINE:20
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.LoginController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/login/login"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:24
// @LINE:23
class ReverseItemController {
    

// @LINE:24
def page : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ItemController.page",
   """
      function(page,pageSize) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/item/page/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("page", page) + "/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("pageSize", pageSize)})
      }
   """
)
                        

// @LINE:23
def addItem : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ItemController.addItem",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/item/add"})
      }
   """
)
                        
    
}
              

// @LINE:17
// @LINE:16
class ReverseRegistrationController {
    

// @LINE:17
def confirmation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RegistrationController.confirmation",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/registration/confirmation/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:16
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.RegistrationController.register",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/registration/register"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:28
// @LINE:24
// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:28
class ReverseAssets {
    

// @LINE:28
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseUserController {
    

// @LINE:11
def getUserByEmail(email:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.getUserByEmail(email), HandlerDef(this, "controllers.UserController", "getUserByEmail", Seq(classOf[String]), "GET", """""", _prefix + """api/user/getByEmail/$email<[^/]+>""")
)
                      

// @LINE:12
def getUsers(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.getUsers(), HandlerDef(this, "controllers.UserController", "getUsers", Seq(), "GET", """""", _prefix + """api/user/query""")
)
                      

// @LINE:13
def saveUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.saveUser(), HandlerDef(this, "controllers.UserController", "saveUser", Seq(), "POST", """""", _prefix + """api/user/save""")
)
                      

// @LINE:9
def getUser(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.getUser(id), HandlerDef(this, "controllers.UserController", "getUser", Seq(classOf[Integer]), "GET", """ users""", _prefix + """api/user/get/$id<[^/]+>""")
)
                      

// @LINE:10
def getUserByToken(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.UserController.getUserByToken(), HandlerDef(this, "controllers.UserController", "getUserByToken", Seq(), "GET", """""", _prefix + """api/user/getByToken""")
)
                      
    
}
                          

// @LINE:20
class ReverseLoginController {
    

// @LINE:20
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.LoginController.login(), HandlerDef(this, "controllers.LoginController", "login", Seq(), "POST", """ login""", _prefix + """api/login/login""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:24
// @LINE:23
class ReverseItemController {
    

// @LINE:24
def page(page:Integer, pageSize:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ItemController.page(page, pageSize), HandlerDef(this, "controllers.ItemController", "page", Seq(classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """api/item/page/$page<[^/]+>/$pageSize<[^/]+>""")
)
                      

// @LINE:23
def addItem(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ItemController.addItem(), HandlerDef(this, "controllers.ItemController", "addItem", Seq(), "POST", """ items""", _prefix + """api/item/add""")
)
                      
    
}
                          

// @LINE:17
// @LINE:16
class ReverseRegistrationController {
    

// @LINE:17
def confirmation(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RegistrationController.confirmation(id), HandlerDef(this, "controllers.RegistrationController", "confirmation", Seq(classOf[String]), "GET", """""", _prefix + """api/registration/confirmation/$id<[^/]+>""")
)
                      

// @LINE:16
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.RegistrationController.register(), HandlerDef(this, "controllers.RegistrationController", "register", Seq(), "POST", """ registration""", _prefix + """api/registration/register""")
)
                      
    
}
                          
}
        
    