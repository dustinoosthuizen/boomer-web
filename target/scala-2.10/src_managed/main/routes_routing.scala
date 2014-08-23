// @SOURCE:/home/dustin/Dev/boomer/conf/routes
// @HASH:57ae00f0992b471f425539a1ab3d3a21b97b5393
// @DATE:Sun Aug 17 20:26:01 SAST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_UserController_getUser1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user/get/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:10
private[this] lazy val controllers_UserController_getUserByToken2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user/getByToken"))))
        

// @LINE:11
private[this] lazy val controllers_UserController_getUserByEmail3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user/getByEmail/"),DynamicPart("email", """[^/]+""",true))))
        

// @LINE:12
private[this] lazy val controllers_UserController_getUsers4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user/query"))))
        

// @LINE:13
private[this] lazy val controllers_UserController_saveUser5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/user/save"))))
        

// @LINE:16
private[this] lazy val controllers_RegistrationController_register6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/registration/register"))))
        

// @LINE:17
private[this] lazy val controllers_RegistrationController_confirmation7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/registration/confirmation/"),DynamicPart("id", """[^/]+""",true))))
        

// @LINE:20
private[this] lazy val controllers_LoginController_login8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/login/login"))))
        

// @LINE:23
private[this] lazy val controllers_ItemController_addItem9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/item/add"))))
        

// @LINE:24
private[this] lazy val controllers_ItemController_page10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("api/item/page/"),DynamicPart("page", """[^/]+""",true),StaticPart("/"),DynamicPart("pageSize", """[^/]+""",true))))
        

// @LINE:28
private[this] lazy val controllers_Assets_at11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user/get/$id<[^/]+>""","""controllers.UserController.getUser(id:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user/getByToken""","""controllers.UserController.getUserByToken()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user/getByEmail/$email<[^/]+>""","""controllers.UserController.getUserByEmail(email:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user/query""","""controllers.UserController.getUsers()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/user/save""","""controllers.UserController.saveUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/registration/register""","""controllers.RegistrationController.register()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/registration/confirmation/$id<[^/]+>""","""controllers.RegistrationController.confirmation(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/login/login""","""controllers.LoginController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/item/add""","""controllers.ItemController.addItem()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """api/item/page/$page<[^/]+>/$pageSize<[^/]+>""","""controllers.ItemController.page(page:Integer, pageSize:Integer)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_UserController_getUser1(params) => {
   call(params.fromPath[Integer]("id", None)) { (id) =>
        invokeHandler(controllers.UserController.getUser(id), HandlerDef(this, "controllers.UserController", "getUser", Seq(classOf[Integer]),"GET", """ users""", Routes.prefix + """api/user/get/$id<[^/]+>"""))
   }
}
        

// @LINE:10
case controllers_UserController_getUserByToken2(params) => {
   call { 
        invokeHandler(controllers.UserController.getUserByToken(), HandlerDef(this, "controllers.UserController", "getUserByToken", Nil,"GET", """""", Routes.prefix + """api/user/getByToken"""))
   }
}
        

// @LINE:11
case controllers_UserController_getUserByEmail3(params) => {
   call(params.fromPath[String]("email", None)) { (email) =>
        invokeHandler(controllers.UserController.getUserByEmail(email), HandlerDef(this, "controllers.UserController", "getUserByEmail", Seq(classOf[String]),"GET", """""", Routes.prefix + """api/user/getByEmail/$email<[^/]+>"""))
   }
}
        

// @LINE:12
case controllers_UserController_getUsers4(params) => {
   call { 
        invokeHandler(controllers.UserController.getUsers(), HandlerDef(this, "controllers.UserController", "getUsers", Nil,"GET", """""", Routes.prefix + """api/user/query"""))
   }
}
        

// @LINE:13
case controllers_UserController_saveUser5(params) => {
   call { 
        invokeHandler(controllers.UserController.saveUser(), HandlerDef(this, "controllers.UserController", "saveUser", Nil,"POST", """""", Routes.prefix + """api/user/save"""))
   }
}
        

// @LINE:16
case controllers_RegistrationController_register6(params) => {
   call { 
        invokeHandler(controllers.RegistrationController.register(), HandlerDef(this, "controllers.RegistrationController", "register", Nil,"POST", """ registration""", Routes.prefix + """api/registration/register"""))
   }
}
        

// @LINE:17
case controllers_RegistrationController_confirmation7(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        invokeHandler(controllers.RegistrationController.confirmation(id), HandlerDef(this, "controllers.RegistrationController", "confirmation", Seq(classOf[String]),"GET", """""", Routes.prefix + """api/registration/confirmation/$id<[^/]+>"""))
   }
}
        

// @LINE:20
case controllers_LoginController_login8(params) => {
   call { 
        invokeHandler(controllers.LoginController.login(), HandlerDef(this, "controllers.LoginController", "login", Nil,"POST", """ login""", Routes.prefix + """api/login/login"""))
   }
}
        

// @LINE:23
case controllers_ItemController_addItem9(params) => {
   call { 
        invokeHandler(controllers.ItemController.addItem(), HandlerDef(this, "controllers.ItemController", "addItem", Nil,"POST", """ items""", Routes.prefix + """api/item/add"""))
   }
}
        

// @LINE:24
case controllers_ItemController_page10(params) => {
   call(params.fromPath[Integer]("page", None), params.fromPath[Integer]("pageSize", None)) { (page, pageSize) =>
        invokeHandler(controllers.ItemController.page(page, pageSize), HandlerDef(this, "controllers.ItemController", "page", Seq(classOf[Integer], classOf[Integer]),"GET", """""", Routes.prefix + """api/item/page/$page<[^/]+>/$pageSize<[^/]+>"""))
   }
}
        

// @LINE:28
case controllers_Assets_at11(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     