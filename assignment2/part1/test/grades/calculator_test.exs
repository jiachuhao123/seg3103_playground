defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator
  
  @commonhwlab %{
                 homework: [0.8],
                 labs: [1, 1, 1],
                 midterm: 0.70,
                 final: 0.9
            }
  @commonlab %{
                 homework: [],
                 labs: [1, 1, 1],
                 midterm: 0.70,
                 final: 0.9
               }
  @common %{
                 homework: [],
                 labs: [],
                 midterm: 0.70,
                 final: 0.9
               }
  @commonhw   %{
                 homework: [0.8],
                 labs: [],
                 midterm: 0.70,
                 final: 0.9
               }
               
  @commonhwlt0_4 %{
                 homework: [0.3],
                 labs: [0.8, 0.8, 0.8],
                 midterm: 0.70,
                 final: 0.9
               }               

  @commonexamlt0_4 %{
	 homework: [0.8, 0.8],
	 labs: [0.3, 0.3, 0.3],
	 midterm: 0.3,
	 final: 0.3
   }               

  @commonnlablt3 %{
	 homework: [0.8, 0.8],
	 labs: [0.8, 0.8],
	 midterm: 0.70,
	 final: 0.9
   }               
   
  
   
  describe "percentage_grade/1" do
    test "homework and labs" do
      assert 85 == Calculator.percentage_grade(@commonhwlab)
    end
    test "homework" do
      assert 65 == Calculator.percentage_grade(@commonhw)
    end
    test "labs" do
      assert 61 == Calculator.percentage_grade(@commonlab)
    end
    test "no hw and no labs" do
      assert 41 == Calculator.percentage_grade(@common)
    end
  end
  
  describe "letter_grade/1" do
    test "homework and labs" do
      assert "A" == Calculator.letter_grade(@commonhwlab)
    end                                   
    test "homework" do                    
      assert "EIN" == Calculator.letter_grade(@commonhw)
    end                                   
    test "labs" do                        
      assert "EIN" == Calculator.letter_grade(@commonlab)
    end                                   
    test "no hw and no labs" do           
      assert "EIN" == Calculator.letter_grade(@common)
    end
    
    test "hw < 0.4" do                    
      assert "EIN" == Calculator.letter_grade(@commonhwlt0_4)
    end
    
    test "exam < 0.4" do                    
      assert "EIN" == Calculator.letter_grade(@commonexamlt0_4)
    end
    
    test "num_lab < 3" do                    
      assert "EIN" == Calculator.letter_grade(@commonnlablt3)
    end
    
    test "grades" do
      %{0.9 => "A+", 
        0.85 => "A", 
        0.8 => "A-", 
        0.75 => "B+",
        0.7 => "B", 
        0.65 => "C+",
        0.6 => "C", 
        0.55 => "D+", 
        0.5 => "D", 
        0.45 => "E"
      }
      |> Enum.each(fn {k, v} ->
         assert v == Calculator.letter_grade(%{
            homework: [k, k, k],
            labs: [k, k, k],
            midterm: k,
            final: k
         })
         
         assert "F" == Calculator.letter_grade(%{
            homework: [0.4, 0.4, 0.4],
            labs: [0, 0, 0, 0, 0, 0, 0.4, 0.4, 0.4],
            midterm: 0.4,
            final: 0.4
         })
               
      end)
    end
    
  end
  
  describe "numeric_grade/1" do
    test "homework and labs" do
      assert 9 == Calculator.numeric_grade(@commonhwlab)
    end                                    
    test "homework" do                     
      assert 0 == Calculator.numeric_grade(@commonhw)
    end                                    
    test "labs" do                         
      assert 0 == Calculator.numeric_grade(@commonlab)
    end                                    
    test "no hw and no labs" do            
      assert 0 == Calculator.numeric_grade(@common)
    end
    test "hw < 0.4" do                    
      assert 0 == Calculator.numeric_grade(@commonhwlt0_4)
    end
    
    test "exam < 0.4" do                    
      assert 0 == Calculator.numeric_grade(@commonexamlt0_4)
    end
    
    test "num_lab < 3" do                    
      assert 0 == Calculator.numeric_grade(@commonnlablt3)
    end
    
    test "grades" do
      %{0.9 => 10, 
        0.85 => 9, 
        0.8 => 8, 
        0.75 => 7,
        0.7 => 6, 
        0.65 => 5,
        0.6 => 4, 
        0.55 => 3, 
        0.5 => 2, 
        0.45 => 1
      }
      |> Enum.each(fn {k, v} ->
         assert v == Calculator.numeric_grade(%{
            homework: [k, k, k],
            labs: [k, k, k],
            midterm: k,
            final: k
         })
         
         assert 0 == Calculator.numeric_grade(%{
            homework: [0.4, 0.4, 0.4],
            labs: [0, 0, 0, 0, 0, 0, 0.4, 0.4, 0.4],
            midterm: 0.4,
            final: 0.4
         })
               
      end)
    end
    
  end
  
end


