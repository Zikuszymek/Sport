package com.mobile.ziku.sport.models

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "gsmrs")
data class BaseResponse(
        @field:Attribute(name = "version") var version: String? = null,
        @field:Attribute(name = "sport") var sport: String? = null,
        @field:Attribute(name = "lang") var lang: String? = null,
        @field:Attribute(name = "last_generated") var lastGenerated: String? = null,
        @field:Element(name = "method") var method: Method? = null,
        @field:Element(name = "competition") var competition: Competition? = null
)

data class Method(
        @field:Attribute(name = "method_id") var methodId: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:ElementList(name = "parameter", inline = true) var parameters: ArrayList<Parameter>? = null
)

data class Parameter(
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "value") var value: String? = null
)

data class Competition(
        @field:Attribute(name = "competition_id") var competitionId: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "teamtype") var teamType: String? = null,
        @field:Attribute(name = "display_order") var displayOrder: Long? = null,
        @field:Attribute(name = "type") var type: String? = null,
        @field:Attribute(name = "area_id") var areaId: Long? = null,
        @field:Attribute(name = "area_name") var areaName: String? = null,
        @field:Attribute(name = "last_updated") var lastUpdate: String? = null,
        @field:Attribute(name = "soccertype") var soccertype: String? = null,
        @field:Element(name = "season") var season: Season? = null
)

data class Season(
        @field:Attribute(name = "season_id") var seasonId: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "start_date") var startDate: String? = null,
        @field:Attribute(name = "end_date") var endDate: String? = null,
        @field:Attribute(name = "service_level") var serviceLevel: Long? = null,
        @field:Attribute(name = "last_updated") var lastUpdated: String? = null,
        @field:Attribute(name = "last_playedmatch_date", required = false) var lastPlayedMatchDate: String? = null,
        @field:Element(name = "round") var round: Round? = null
)

data class Round(
        @field:Attribute(name = "round_id") var groupId: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "start_date") var startDate: String? = null,
        @field:Attribute(name = "end_date") var endDate: String? = null,
        @field:Attribute(name = "type") var type: String? = null,
        @field:Attribute(name = "groups") var groups: Int? = null,
        @field:Attribute(name = "has_outgroup_matches") var hasOutGroupMaches: String? = null,
        @field:Attribute(name = "last_updated", required = false) var lastUpdated: String? = null,
        @field:Attribute(name = "ordermethod", required = false) var ordermethod: String? = null,
        @field:ElementList(name = "group", inline = true, required = false) var group: ArrayList<Group>? = null,
        @field:Element(name = "resultstable", required = false) var resultsTable: ResultsTable? = null
)

data class Group(
        @field:Attribute(name = "group_id") var groupId: Long? = null,
        @field:Attribute(name = "name") var name: String? = null,
        @field:Attribute(name = "details") var details: String? = null,
        @field:Attribute(name = "winner") var winner: String? = null,
        @field:Attribute(name = "last_updated") var lastUpdated: String? = null,
        @field:ElementList(name = "march", inline = true) var matches: ArrayList<Match>? = null
)

data class Match(
        @field:Attribute(name = "match_id") var matchId: Long? = null,
        @field:Attribute(name = "date_utc") var dateUtc: String? = null,
        @field:Attribute(name = "time_utc") var timeUtc: String? = null,
        @field:Attribute(name = "date_london") var dateLondon: String? = null,
        @field:Attribute(name = "time_london") var timeLondon: String? = null,
        @field:Attribute(name = "team_A_id") var teamAId: Long? = null,
        @field:Attribute(name = "team_A_name") var teamAName: String? = null,
        @field:Attribute(name = "team_A_country") var teamACountry: String? = null,
        @field:Attribute(name = "team_B_id") var teamBId: Long? = null,
        @field:Attribute(name = "team_B_name") var teamBName: String? = null,
        @field:Attribute(name = "team_B_country") var teamBCountry: String? = null,
        @field:Attribute(name = "status") var status: String? = null,
        @field:Attribute(name = "gameweek") var geameWeek: String? = null,
        @field:Attribute(name = "winner") var winner: String? = null,
        @field:Attribute(name = "fs_A") var fsA: String? = null,
        @field:Attribute(name = "fs_B") var fsB: String? = null,
        @field:Attribute(name = "hts_A") var htsA: String? = null,
        @field:Attribute(name = "hts_B") var htsB: String? = null,
        @field:Attribute(name = "ets_A") var etsA: String? = null,
        @field:Attribute(name = "ets_B") var etsB: String? = null,
        @field:Attribute(name = "ps_A") var psA: String? = null,
        @field:Attribute(name = "ps_B") var psB: String? = null,
        @field:Attribute(name = "last_updated") var lastUpdated: String? = null
)

data class ResultsTable(
        @field:Attribute(name = "type") var total: String? = null,
        @field:ElementList(name = "ranking", inline = true) var rankings: ArrayList<Ranking>? = null
)

data class Ranking(
        @field:Attribute(name = "rank") var rank: Int? = null,
        @field:Attribute(name = "last_rank") var lastRand: Int? = null,
        @field:Attribute(name = "zone_start", required = false) var zoneStart: String? = null,
        @field:Attribute(name = "zone_end", required = false) var zoneEnb: String? = null,
        @field:Attribute(name = "team_id") var teamId: Long? = null,
        @field:Attribute(name = "club_name") var clubName: String? = null,
        @field:Attribute(name = "countrycode") var countryCode: String? = null,
        @field:Attribute(name = "area_id") var areaId: String? = null,
        @field:Attribute(name = "matches_total") var matchesTotal: Int? = null,
        @field:Attribute(name = "matches_won") var matchesWon: Int? = null,
        @field:Attribute(name = "matches_draw") var matchesDraw: Int? = null,
        @field:Attribute(name = "matches_lost") var matchesLost: Int? = null,
        @field:Attribute(name = "goals_pro") var goalsPro: Int? = null,
        @field:Attribute(name = "goals_against") var goalsAgainst: Int? = null,
        @field:Attribute(name = "points") var points: Int? = null
)
