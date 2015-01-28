require_relative 'lib/ebbinghaus_reminder'

if ARGV.size == 0
  reminder = EbbinghausReminder.today()
else
  reminder = EbbinghausReminder.today_is(ARGV[0])
end

for date in reminder.dates_to_be_reviewed() do
  puts date
end

for date in reminder.random_dates_to_be_reviewed_after("2014-08-22") do
  puts date
end