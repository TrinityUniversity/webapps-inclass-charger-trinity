package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import models._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  val cols = "team                 won lost min  fgm  fga   3m   3a  ftm  fta   or   tr   as   st   to   bk   pf   pts  tc  ej  ff"

  val data = """AtlantaHawks         41   41 19441 3592 7399  979 2749 1524 1899  866 3617 2131  616 1106  414 1612  9687   0   0   0
  BostonCeltics        25   57 19551 3425 7395  954 2762 1332 1733  800 3609 1895  543  985  318 1568  9136   0   0   0
  CharlotteHornets     55   27 19401 3522 7392 1004 2813 1562 1965  897 3789 2127  571 1128  471 1667  9610   0   0   0
  ChicagoBulls         42   40 19483 3339 7143 1086 3042 1406 1806  790 3554 2132  546 1161  389 1537  9170   0   0   0
  ClevelandCavaliers   31   51 19470 3201 6845  924 2507 1438 1838  801 3380 1888  574 1204  360 1671  8764   0   0   0
  DallasMavericks      44   38 19510 3425 7064  913 2596 1597 2046  829 3666 2044  522 1018  312 1789  9360   0   0   0
  DenverNuggets        29   53 19320 3422 7164  932 2710 1443 1861  832 3349 2105  646 1061  345 1601  9219   0   0   0
  DetroitPistons       65   17 19383 3533 7221  984 2730 1669 2149  899 3666 2112  631 1059  453 1718  9719   0   0   0
  GSWarriors           38   44 19422 3478 7421 1060 2914 1589 2067  879 3551 2110  646 1110  326 1510  9605   0   0   0
  HoustonRockets       60   22 19334 3480 7226 1189 3183 1574 1984  860 3402 2143  718 1030  509 1692  9723   0   0   0
  IndianaPacers        47   35 19349 3549 7322 1019 2733 1679 2100  992 3713 2163  650 1166  438 1660  9796   0   0   0
  LAClippers           38   44 19415 3430 7244 1000 2738 1413 1832  838 3537 2048  639 1012  343 1606  9273   0   0   0
  LALakers             39   43 19449 3607 7697 1028 2991 1319 1706  908 3678 2104  624  992  417 1760  9561   0   0   0
  MemphisGrizzlies     31   51 19380 3340 7365 1065 2998 1519 1931  901 3639 2167  559 1182  426 1644  9264   0   0   0
  MiamiHeat            38   44 19415 3288 6822 1077 2934 1350 1728  730 3432 2097  572 1231  309 1644  9003   0   0   0
  MilwaukeeBucks       24   58 19435 3483 7645  991 2799 1334 1719  880 3624 1963  578  942  322 1557  9291   0   0   0
  MinnesotaT-wolves    40   42 19411 3428 7276 1007 2730 1634 2133  928 3662 2051  675 1205  336 1654  9497   0   0   0
  BrooklynNets         37   45 19305 3360 7255  968 2640 1537 2003  942 3701 1916  574 1068  318 1517  9225   0   0   0
  NOrleansPelicans     40   42 19441 3356 7104 1002 2953 1507 1935  791 3425 2044  600 1175  386 1673  9221   0   0   0
  NYKnicks             35   47 19532 3343 7230 1068 2993 1520 1943  830 3447 2062  497  988  370 1694  9274   0   0   0
  OrlandoMagic         48   34 19357 3389 7127 1064 3030 1504 1890  779 3448 2122  634 1155  416 1680  9346   0   0   0
  Philadelphia76ers    28   54 19468 3312 7005  952 2736 1518 1943  782 3374 1986  540 1107  381 1606  9094   0   0   0
  PhoenixSuns          37   45 19368 3280 7043  938 2626 1651 2101  840 3515 1915  588 1114  327 1629  9149   0   0   0
  PortlandTrailBlazers 49   33 19297 3522 7178 1029 2717 1555 1977  859 3545 2214  640 1055  352 1679  9628   0   0   0
  SacramentoKings      34   48 19420 3589 7288 1022 2740 1481 1882  795 3460 2187  598 1117  340 1711  9681   0   0   0
  SanAntonioSpurs      60   22 19414 3780 7460 1036 2651 1496 1942  877 3688 2198  665 1079  432 1516 10092   0   0   0
  OklahomaCityThunder  42   40 19442 3437 7251 1059 2955 1611 2090  980 3821 2126  573 1325  455 1675  9544   0   0   0
  TorontoRaptors       41   41 19398 3312 6752 1001 2676 1508 1893  757 3466 2148  492 1302  376 1604  9133   0   0   0
  UtahJazz             45   37 19395 3555 7516 1023 2830 1544 1989  921 3564 2047  639  985  407 1679  9677   0   0   0
  WashingtonWizards    47   35 19344 3481 7362  984 2687 1432 1794  882 3527 2035  581  971  406 1590  9378   0   0   0"""

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def foo = Action {
    val rows = this.data.split('\n')
    Ok(views.html.foo(cols, rows))
  }

  def getForm = Action {
    Ok(views.html.form())
  }

  def handleSubmission(username: String, color: String) = Action {
    Ok(s"$username likes the color $color")
  }

  def handleSubmissionPost = Action { request => 
    val postVals = request.body.asFormUrlEncoded
    postVals.map { args => 
      val email = args("email").head
      val year = args("year").head
      if (StudentDataModel.validateStudent(email, year)) {
        Ok(views.html.logged(email, year))
      } else {
        Redirect(routes.Application.getForm);
      }   
    }.getOrElse(Ok("Shawty done messed up"))
  }

  def getNumber = Action {
    Ok(views.html.ctr(CountingModel.getNumber()))
  }

}

