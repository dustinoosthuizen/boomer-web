
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html ng-app="myapp">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Boomer</title>

            <!-- Bootstrap -->
        <link href='"""),_display_(Seq[Any](/*10.22*/routes/*10.28*/.Assets.at("stylesheets/ngDialog.min.css"))),format.raw/*10.70*/("""' rel="stylesheet">
        <link href='"""),_display_(Seq[Any](/*11.22*/routes/*11.28*/.Assets.at("stylesheets/ngDialog-theme-default.min.css"))),format.raw/*11.84*/("""' rel="stylesheet">
        <link href='"""),_display_(Seq[Any](/*12.22*/routes/*12.28*/.Assets.at("stylesheets/ngDialog-theme-plain.min.css"))),format.raw/*12.82*/("""' rel="stylesheet">
        <link href='"""),_display_(Seq[Any](/*13.22*/routes/*13.28*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*13.71*/("""' rel="stylesheet">
        <link href='"""),_display_(Seq[Any](/*14.22*/routes/*14.28*/.Assets.at("stylesheets/main.css"))),format.raw/*14.62*/("""' rel="stylesheet">
            <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>
      <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

            <![endif]-->
    </head>
    <body>

            """),format.raw/*26.89*/("""
                """),format.raw/*27.77*/("""
                    """),format.raw/*28.52*/("""
                        """),format.raw/*29.131*/("""
                            """),format.raw/*30.79*/("""
                            """),format.raw/*31.63*/("""
                            """),format.raw/*32.63*/("""
                            """),format.raw/*33.63*/("""
                        """),format.raw/*34.38*/("""
                        """),format.raw/*35.100*/("""
                    """),format.raw/*36.31*/("""
                    """),format.raw/*37.83*/("""
                    """),format.raw/*38.31*/("""
                """),format.raw/*39.27*/("""
            """),format.raw/*40.23*/("""


        """),format.raw/*43.31*/("""
            <div ui-view>


            </div>
        """),format.raw/*48.19*/("""
                <!-- /.container -->

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular-resource.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.4/angular-cookies.js"></script>
        <script src="//angular-ui.github.io/ui-router/release/angular-ui-router.js"></script>
        <script src='"""),_display_(Seq[Any](/*56.23*/routes/*56.29*/.Assets.at("javascripts/other/bootstrap.min.js"))),format.raw/*56.77*/("""'></script>
        <script src='"""),_display_(Seq[Any](/*57.23*/routes/*57.29*/.Assets.at("javascripts/other/ng-grid.js"))),format.raw/*57.71*/("""' type="text/javascript"></script>
        <script src='"""),_display_(Seq[Any](/*58.23*/routes/*58.29*/.Assets.at("javascripts/other/ngDialog.min.js"))),format.raw/*58.76*/("""' type="text/javascript"></script>


        """),format.raw/*61.17*/("""
        <script src='"""),_display_(Seq[Any](/*62.23*/routes/*62.29*/.Assets.at("javascripts/config/app.js"))),format.raw/*62.68*/("""' type="text/javascript"></script>

        """),format.raw/*64.24*/("""
        <script src='"""),_display_(Seq[Any](/*65.23*/routes/*65.29*/.Assets.at("javascripts/controllers/userController.js"))),format.raw/*65.84*/("""' type="text/javascript"></script>
        <script src='"""),_display_(Seq[Any](/*66.23*/routes/*66.29*/.Assets.at("javascripts/controllers/loginController.js"))),format.raw/*66.85*/("""' type="text/javascript"></script>
        <script src='"""),_display_(Seq[Any](/*67.23*/routes/*67.29*/.Assets.at("javascripts/controllers/registerController.js"))),format.raw/*67.88*/("""' type="text/javascript"></script>
        <script src='"""),_display_(Seq[Any](/*68.23*/routes/*68.29*/.Assets.at("javascripts/controllers/navbarController.js"))),format.raw/*68.86*/("""' type="text/javascript"></script>
        <script src='"""),_display_(Seq[Any](/*69.23*/routes/*69.29*/.Assets.at("javascripts/controllers/itemController.js"))),format.raw/*69.84*/("""' type="text/javascript"></script>


        """),format.raw/*72.21*/("""
        <script src='"""),_display_(Seq[Any](/*73.23*/routes/*73.29*/.Assets.at("javascripts/services/userService.js"))),format.raw/*73.78*/("""' type="text/javascript"></script>
        <script src='"""),_display_(Seq[Any](/*74.23*/routes/*74.29*/.Assets.at("javascripts/services/registrationService.js"))),format.raw/*74.86*/("""' type="text/javascript"></script>
        <script src='"""),_display_(Seq[Any](/*75.23*/routes/*75.29*/.Assets.at("javascripts/services/loginService.js"))),format.raw/*75.79*/("""' type="text/javascript"></script>
        <script src='"""),_display_(Seq[Any](/*76.23*/routes/*76.29*/.Assets.at("javascripts/services/itemService.js"))),format.raw/*76.78*/("""' type="text/javascript"></script>



        """),format.raw/*80.22*/("""
        <script src='"""),_display_(Seq[Any](/*81.23*/routes/*81.29*/.Assets.at("javascripts/factories/authInterceptor.js"))),format.raw/*81.83*/("""' type="text/javascript"></script>

    </body>
</html>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Aug 17 19:50:40 SAST 2014
                    SOURCE: /home/dustin/Dev/boomer/app/views/index.scala.html
                    HASH: 91c73c648b9446a63cda5023428dd342e24b49f0
                    MATRIX: 855->0|1193->302|1208->308|1272->350|1349->391|1364->397|1442->453|1519->494|1534->500|1610->554|1687->595|1702->601|1767->644|1844->685|1859->691|1915->725|2508->1366|2553->1443|2602->1495|2656->1626|2713->1705|2770->1768|2827->1831|2884->1894|2937->1932|2991->2032|3040->2063|3089->2146|3138->2177|3183->2204|3224->2227|3263->2260|3347->2326|3926->2869|3941->2875|4011->2923|4081->2957|4096->2963|4160->3005|4253->3062|4268->3068|4337->3115|4410->3168|4469->3191|4484->3197|4545->3236|4617->3295|4676->3318|4691->3324|4768->3379|4861->3436|4876->3442|4954->3498|5047->3555|5062->3561|5143->3620|5236->3677|5251->3683|5330->3740|5423->3797|5438->3803|5515->3858|5588->3915|5647->3938|5662->3944|5733->3993|5826->4050|5841->4056|5920->4113|6013->4170|6028->4176|6100->4226|6193->4283|6208->4289|6279->4338|6353->4397|6412->4420|6427->4426|6503->4480
                    LINES: 29->1|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|54->26|55->27|56->28|57->29|58->30|59->31|60->32|61->33|62->34|63->35|64->36|65->37|66->38|67->39|68->40|71->43|76->48|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|86->58|89->61|90->62|90->62|90->62|92->64|93->65|93->65|93->65|94->66|94->66|94->66|95->67|95->67|95->67|96->68|96->68|96->68|97->69|97->69|97->69|100->72|101->73|101->73|101->73|102->74|102->74|102->74|103->75|103->75|103->75|104->76|104->76|104->76|108->80|109->81|109->81|109->81
                    -- GENERATED --
                */
            