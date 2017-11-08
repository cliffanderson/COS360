public class g46{


   private static CofinFin w = new CofinFin();

   private static CofinFin s1 = new CofinFin();

   private static CofinFin s2 = new CofinFin();

   private static CofinFin s3 = new CofinFin();

   private static CofinFin first = new CofinFin();

   private static CofinFin second = new CofinFin();

   private static CofinFin third = new CofinFin();

   public static void main(String[] args){


      CofinFin $sv1 = new CofinFin(false, new int[] {});
      w = $sv1;

      $sv1 = new CofinFin(false, new int[] {});
      s1 = $sv1;

      $sv1 = new CofinFin(false, new int[] {0});
      s2 = $sv1;

      $sv1 = new CofinFin(false, new int[] {0,1});
      s3 = $sv1;

      if (s3.isSubsetOf(s2)){
         if (s3.isSubsetOf(s1)){
            first = s3;

            if (s2.isSubsetOf(s1)){
               second = s2;

               third = s1;

            }
            else{
               second = s1;

               third = s2;

            }

         }
         else{
            first = s1;

            second = s3;

            third = s2;

         }

      }
      else{
         if (s1.isSubsetOf(s2)){
            first = s1;

            second = s2;

            third = s3;

         }
         else{
            first = s2;

            if (s3.isSubsetOf(s1)){
               second = s3;

               third = s1;

            }
            else{
               second = s1;

               third = s3;

            }

         }

      }

      $sv1 = new CofinFin(false, new int[] {});
      w = $sv1;

      if (first.equals(s1)){
         if (second.equals(s2)){
            if (third.equals(s3)){
               $sv1 = new CofinFin(false, new int[] {123});
               w = $sv1;

            }
            else{
               if (third.equals(s2)){
                  $sv1 = new CofinFin(false, new int[] {122});
                  w = $sv1;

               }
               else{
                  if (third.equals(s1)){
                     $sv1 = new CofinFin(false, new int[] {121});
                     w = $sv1;

                  }

               }

            }

         }
         else{
            if (second.equals(s3)){
               if (third.equals(s3)){
                  $sv1 = new CofinFin(false, new int[] {133});
                  w = $sv1;

               }
               else{
                  if (third.equals(s2)){
                     $sv1 = new CofinFin(false, new int[] {132});
                     w = $sv1;

                  }
                  else{
                     if (third.equals(s1)){
                        $sv1 = new CofinFin(false, new int[] {131});
                        w = $sv1;

                     }

                  }

               }

            }
            else{
               if (second.equals(s1)){
                  if (third.equals(s3)){
                     $sv1 = new CofinFin(false, new int[] {113});
                     w = $sv1;

                  }
                  else{
                     if (third.equals(s2)){
                        $sv1 = new CofinFin(false, new int[] {112});
                        w = $sv1;

                     }
                     else{
                        if (third.equals(s1)){
                           $sv1 = new CofinFin(false, new int[] {111});
                           w = $sv1;

                        }

                     }

                  }

               }

            }

         }

      }
      else{
         if (first.equals(s2)){
            if (second.equals(s2)){
               if (third.equals(s3)){
                  $sv1 = new CofinFin(false, new int[] {223});
                  w = $sv1;

               }
               else{
                  if (third.equals(s2)){
                     $sv1 = new CofinFin(false, new int[] {222});
                     w = $sv1;

                  }
                  else{
                     if (third.equals(s1)){
                        $sv1 = new CofinFin(false, new int[] {221});
                        w = $sv1;

                     }

                  }

               }

            }
            else{
               if (second.equals(s3)){
                  if (third.equals(s3)){
                     $sv1 = new CofinFin(false, new int[] {233});
                     w = $sv1;

                  }
                  else{
                     if (third.equals(s2)){
                        $sv1 = new CofinFin(false, new int[] {232});
                        w = $sv1;

                     }
                     else{
                        if (third.equals(s1)){
                           $sv1 = new CofinFin(false, new int[] {231});
                           w = $sv1;

                        }

                     }

                  }

               }
               else{
                  if (second.equals(s1)){
                     if (third.equals(s3)){
                        $sv1 = new CofinFin(false, new int[] {213});
                        w = $sv1;

                     }
                     else{
                        if (third.equals(s2)){
                           $sv1 = new CofinFin(false, new int[] {212});
                           w = $sv1;

                        }
                        else{
                           if (third.equals(s1)){
                              $sv1 = new CofinFin(false, new int[] {211});
                              w = $sv1;

                           }

                        }

                     }

                  }

               }

            }

         }
         else{
            if (first.equals(s3)){
               if (second.equals(s2)){
                  if (third.equals(s3)){
                     $sv1 = new CofinFin(false, new int[] {323});
                     w = $sv1;

                  }
                  else{
                     if (third.equals(s2)){
                        $sv1 = new CofinFin(false, new int[] {322});
                        w = $sv1;

                     }
                     else{
                        if (third.equals(s1)){
                           $sv1 = new CofinFin(false, new int[] {321});
                           w = $sv1;

                        }

                     }

                  }

               }
               else{
                  if (second.equals(s3)){
                     if (third.equals(s3)){
                        $sv1 = new CofinFin(false, new int[] {333});
                        w = $sv1;

                     }
                     else{
                        if (third.equals(s2)){
                           $sv1 = new CofinFin(false, new int[] {332});
                           w = $sv1;

                        }
                        else{
                           if (third.equals(s1)){
                              $sv1 = new CofinFin(false, new int[] {331});
                              w = $sv1;

                           }

                        }

                     }

                  }
                  else{
                     if (second.equals(s1)){
                        if (third.equals(s3)){
                           $sv1 = new CofinFin(false, new int[] {313});
                           w = $sv1;

                        }
                        else{
                           if (third.equals(s2)){
                              $sv1 = new CofinFin(false, new int[] {312});
                              w = $sv1;

                           }
                           else{
                              if (third.equals(s1)){
                                 $sv1 = new CofinFin(false, new int[] {311});
                                 w = $sv1;

                              }

                           }

                        }

                     }

                  }

               }

            }

         }

      }


      System.out.println(w.toString());
   }
}
// Successful parse.
