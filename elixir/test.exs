IO.puts("Hello world from Elixir")
add = fn a,b -> a+b end
{:ok,v}= File.read("/home/adel/projects/advent_of_code_2022/src/test/resources/day01/inputTest")
if true do
 IO.puts("weee")
end
IO.puts(v)
IO.puts("machin #{add.(2,3)}")
