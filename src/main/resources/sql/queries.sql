select q.block, q.first_choice, q.second_choice, a.answer, a.first_option_unknown, a.second_option_unknown, q.list 
from Survey s 
	inner join Participant p on p.id = s.participant_id
	inner join survey_answers sa on sa.survey_id = s.id
	inner join Answer a on a.id = sa.answers_id
	inner join Question q on q.id = a.question_id 
where p.id = 593
order by q.id