defmodule Grades.Calculator do
  def avg(e) do
     if Enum.count(e) == 0 do
        0
     else
        Enum.sum(e) / Enum.count(e)
     end
  end
  
  def failed_to_participate?(avg_homework, avg_exams, num_labs) do
      avg_homework < 0.4 || avg_exams < 0.4 || num_labs < 3
  end
  
  def calculate_grade(avg_labs, avg_homework, midterm, final) do
      0.2 * avg_labs + 0.3 * avg_homework + 0.2 * midterm + 0.3 * final
  end
  
  # Refactor 1
  def generic_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}, fun) do
    avg_homework = avg(homework)
    avg_labs = avg(labs)
    avg_exams = (midterm + final) / 2
    num_labs =
      labs
      |> Enum.reject(fn mark -> mark < 0.25 end)
      |> Enum.count()
    mark = calculate_grade(avg_labs, avg_homework, midterm, final)
    fun.(failed_to_participate?(avg_homework, avg_exams, num_labs), mark)
  end
  
  # Refactor 2
  def mark_level(mark, [a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11]) do
      cond do
        mark > 0.895 -> a1
        mark > 0.845 -> a2
        mark > 0.795 -> a3
        mark > 0.745 -> a4
        mark > 0.695 -> a5
        mark > 0.645 -> a6
        mark > 0.595 -> a7
        mark > 0.545 -> a8
        mark > 0.495 -> a9
        mark > 0.395 -> a10
        :else -> a11
      end
  end
  
  
  def percentage_grade(w) do
    generic_grade(w, fn(_fail, mark) -> round(mark * 100) end)
  end

  def letter_grade(w) do
    generic_grade(w, fn(fail, mark) -> 
       if fail do
          "EIN"
       else
          mark_level(mark, ["A+", "A", "A-", "B+", "B", "C+", "C", "D+", "D", "E", "F"])
       end
    end)
  end

  def numeric_grade(w) do
    generic_grade(w, fn(fail, mark) -> 
       if fail do
          0
       else
          mark_level(mark, [10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0])
       end
    end)
  end
end
