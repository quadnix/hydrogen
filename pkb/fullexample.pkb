# by default imports use org.kagelabs.pkb_aux
import io

print "Hello World!"

write "What's your name? : "
read $name

#num = 12
$num = "12"

write "Hello, "
write $name
print "!"

$tmp = "Patrick"
if $name == $tmp
print "hello!"
end 